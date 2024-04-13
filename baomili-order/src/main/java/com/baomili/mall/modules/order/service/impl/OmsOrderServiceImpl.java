package com.baomili.mall.modules.order.service.impl;

import com.baomili.mall.modules.order.dto.OmsOrderDto;
import com.baomili.mall.modules.order.dto.OmsOrderItemDto;
import com.baomili.mall.modules.order.dto.OrderQueryParamDto;
import com.baomili.mall.modules.order.model.OmsOrder;
import com.baomili.mall.modules.order.mapper.OmsOrderMapper;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomili.mall.modules.order.service.OmsOrderItemService;
import com.baomili.mall.modules.order.service.OmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.order.vo.OmsOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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
    private RocketMQTemplate rocketMQTemplate;
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
        for (OmsOrderItemDto orderItemDto : omsOrderDto.getOmsOrderItemDtoList()) {
            OmsOrder omsOrder = new OmsOrder();
            BeanUtils.copyProperties(omsOrderDto, omsOrder);
            omsOrder.setOrderNumber(generateOrderNumber());
            omsOrderMapper.insert(omsOrder);

            OmsOrderItem omsOrderItem = new OmsOrderItem();
            BeanUtils.copyProperties(orderItemDto, omsOrderItem);
            omsOrderItem.setOrderId(omsOrder.getId());
            omsOrderItems.add(omsOrderItem);
        }
        omsOrderItemService.saveBatch(omsOrderItems);
        log.info("addOrder 下单成功");
        // 使用MQ异步扣减库存
        rocketMQTemplate.convertAndSend("order", omsOrderItems);
    }

    private String generateOrderNumber() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }

    @Override
    public List<OmsOrderVo> getOrderList(OrderQueryParamDto queryParamDto) {
        return null;
    }
}
