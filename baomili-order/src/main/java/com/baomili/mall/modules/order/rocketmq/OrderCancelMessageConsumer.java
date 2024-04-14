package com.baomili.mall.modules.order.rocketmq;

import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.order.constant.OrderConstant;
import com.baomili.mall.modules.order.feign.PmsProductStockFeignApi;
import com.baomili.mall.modules.order.model.OmsOrder;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomili.mall.modules.order.service.OmsOrderItemService;
import com.baomili.mall.modules.order.service.OmsOrderService;
import com.baomili.mall.modules.order.vo.OmsOrderItemVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "consumerGroup", topic = "order-cancel")
public class OrderCancelMessageConsumer implements RocketMQListener<List<Long>> {

    @Resource
    private OmsOrderService omsOrderService;

    @Resource
    private OmsOrderItemService omsOrderItemService;

    @Resource
    private PmsProductStockFeignApi pmsProductStockFeignApi;

    @Override
    public void onMessage(List<Long> orderIds) {
        log.info("超时未支付 取消订单 入参：{}", orderIds);
        List<OmsOrder> omsOrders = new ArrayList<>();
        for (Long orderId : orderIds) {
            OmsOrder omsOrder = new OmsOrder();
            omsOrder.setId(orderId);
            omsOrder.setStatus(OrderConstant.OrderStatusEnum.INVALID.getValue());
            omsOrders.add(omsOrder);
        }
        omsOrderService.updateBatchById(omsOrders);
        List<OmsOrderItem> omsOrderItems = omsOrderItemService.getOrderItemListByOrderIds(orderIds);
        // 查询明细 还原库存
        List<ReduceStockVo> reduceStockVos = new ArrayList<>();
        for (OmsOrderItem omsOrderItem : omsOrderItems) {
            ReduceStockVo reduceStockVo = new ReduceStockVo();
            reduceStockVo.setProductId(omsOrderItem.getProductId());
            reduceStockVo.setReduceQuantity(omsOrderItem.getQuantity());
            reduceStockVos.add(reduceStockVo);
        }
        pmsProductStockFeignApi.recoverStock(reduceStockVos);
        log.info("超时未支付 取消订单 成功");
    }
}
