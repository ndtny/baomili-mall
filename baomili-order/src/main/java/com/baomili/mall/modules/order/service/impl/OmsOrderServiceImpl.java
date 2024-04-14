package com.baomili.mall.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomili.mall.modules.common.utils.DoubleUtil;
import com.baomili.mall.modules.order.constant.OrderConstant;
import com.baomili.mall.modules.order.constant.RedisKey;
import com.baomili.mall.modules.order.dto.OmsOrderDto;
import com.baomili.mall.modules.order.dto.OmsOrderItemDto;
import com.baomili.mall.modules.order.dto.OrderQueryParamDto;
import com.baomili.mall.modules.order.model.OmsOrder;
import com.baomili.mall.modules.order.mapper.OmsOrderMapper;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomili.mall.modules.order.rocketmq.OrderCancelMessageSender;
import com.baomili.mall.modules.order.rocketmq.ReduceStockMessageSender;
import com.baomili.mall.modules.order.service.OmsOrderItemService;
import com.baomili.mall.modules.order.service.OmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.order.vo.OmsOrderVo;
import com.baomili.mall.modules.redis.utils.RedisSingleUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Service
@Slf4j
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements OmsOrderService {

    @Resource
    private OmsOrderMapper omsOrderMapper;

    @Resource
    private OmsOrderItemService omsOrderItemService;

    @Resource
    private ReduceStockMessageSender reduceStockMessageSender;

    @Resource
    private OrderCancelMessageSender orderCancelMessageSender;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    @Transactional
    public void addOrder(OmsOrderDto omsOrderDto) {
        log.info("addOrder 下单 入参：{}", omsOrderDto);
        if (!Optional.ofNullable(omsOrderDto).isPresent()) {
            throw new RuntimeException("请选择商品");
        }
        if (StringUtils.isBlank(omsOrderDto.getReceiveUser())) {
            throw new RuntimeException("请选择收货人");
        }
        if (StringUtils.isBlank(omsOrderDto.getPhone())) {
            throw new RuntimeException("青填写收货人电话");
        }
        if (StringUtils.isBlank(omsOrderDto.getDetailAddress())) {
            throw new RuntimeException("请选择收货地址");
        }
        if (CollectionUtils.isEmpty(omsOrderDto.getOmsOrderItemDtoList())) {
            throw new RuntimeException("请选择商品");
        }

        List<OmsOrderItem> omsOrderItems = new ArrayList<>();
        List<Long> orderIds = new ArrayList<>();
        for (OmsOrderItemDto orderItemDto : omsOrderDto.getOmsOrderItemDtoList()) {
            OmsOrder omsOrder = new OmsOrder();
            BeanUtils.copyProperties(omsOrderDto, omsOrder);
            omsOrder.setOrderNumber(generateOrderNumber());
            double totalAmount = DoubleUtil.add(orderItemDto.getPrice(), orderItemDto.getQuantity().doubleValue());
            omsOrder.setTotalAmount(new BigDecimal(totalAmount));
            omsOrder.setPayAmount(new BigDecimal(totalAmount));
            omsOrderMapper.insert(omsOrder);
            orderIds.add(omsOrder.getId());

            OmsOrderItem omsOrderItem = new OmsOrderItem();
            BeanUtils.copyProperties(orderItemDto, omsOrderItem);
            omsOrderItem.setOrderId(omsOrder.getId());
            omsOrderItems.add(omsOrderItem);

        }
        omsOrderItemService.saveBatch(omsOrderItems);
        log.info("addOrder 下单成功");
        // 使用MQ异步扣减库存
        boolean result = reduceStockMessageSender.sendReduceStockMessage(omsOrderItems);
        if (!result) {
            throw new RuntimeException("库存不足");
        }
        boolean cancelMessageResult = orderCancelMessageSender.sendOrderCancelMessage(orderIds, 2);
        log.info("addOrder 发送超时未支付取消订单消息 结果：{}", cancelMessageResult);
    }

    private String generateOrderNumber() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        Long increment = redisTemplate.opsForValue().increment(RedisKey.ORDER_NUMBER);
        return format + increment;
    }

    @Override
    public List<OmsOrderVo> getOrderList(OrderQueryParamDto queryParamDto) {
        log.info("getOrderList 用户查询订单 入参：{}", queryParamDto);
        QueryWrapper<OmsOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("memberId", queryParamDto.getMemberId());
        if (queryParamDto.getOrderStatus() != null) {
            queryWrapper.eq("order_status", queryParamDto.getOrderStatus());
        }
        if (StringUtils.isNotBlank(queryParamDto.getProductName())) {
            queryWrapper.likeRight("product_name", queryParamDto.getProductName());
        }
        if (StringUtils.isNotBlank(queryParamDto.getProductBrand())) {
            queryWrapper.likeRight("product_brand", queryParamDto.getProductBrand());
        }
        List<OmsOrder> omsOrders = omsOrderMapper.selectList(queryWrapper);
        List<OmsOrderVo> omsOrderVos = new ArrayList<>();
        for (OmsOrder omsOrder : omsOrders) {
            OmsOrderVo omsOrderVo = new OmsOrderVo();
            BeanUtils.copyProperties(omsOrder, omsOrderVo);
            omsOrderVos.add(omsOrderVo);
        }
        log.info("getOrderList 用户查询订单结束");
        return omsOrderVos;
    }

    @Override
    @Transactional
    public void orderTimeOutCancel() {
        log.info("orderTimeOutCancel 取消超时未支付的订单");
        QueryWrapper<OmsOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", OrderConstant.OrderStatusEnum.PENDING_PAYMENT.getValue());
        List<OmsOrder> omsOrders = omsOrderMapper.selectList(queryWrapper);
        List<OmsOrder> updateStatusOrderList = new ArrayList<>();
        Date date = new Date();
        for (OmsOrder omsOrder : omsOrders) {
            // 未支付，且距离订单创建已超过2分钟，取消订单
            long minute = (date.getTime() - omsOrder.getCreateTime().getTime()) / 6000;
            if ( minute > 2 ) {
                log.info("orderTimeOutCancel 订单【{}】超时未支付，取消", omsOrder.getOrderNumber());
                OmsOrder order = new OmsOrder();
                order.setId(omsOrder.getId());
                order.setStatus(OrderConstant.OrderStatusEnum.INVALID.getValue());
                updateStatusOrderList.add(order);
            }
        }
        if (CollectionUtils.isEmpty(updateStatusOrderList)) {
            log.info("orderTimeOutCancel 没有超时未支付的订单");
            return;
        }
        // 查询明细，还原库存
        log.info("orderTimeOutCancel 存在超时未支付的订单 取消");
        this.updateBatchById(updateStatusOrderList);
    }
}
