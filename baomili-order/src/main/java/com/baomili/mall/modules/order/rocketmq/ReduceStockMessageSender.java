package com.baomili.mall.modules.order.rocketmq;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ReduceStockMessageSender {

    @Resource
    private ExtRocketMQTemplate extRocketMQTemplate;

    public void sendReduceStockMessage(Long orderId, List<OmsOrderItem> omsOrderItems) {
        log.info("sendReduceStockMessage 发送扣减库存消息 入参：{} {}", orderId, omsOrderItems);
        List<ReduceStockVo> reduceStockVos = new ArrayList<>();
        for (OmsOrderItem omsOrderItem : omsOrderItems) {
            ReduceStockVo reduceStockVo = new ReduceStockVo();
            reduceStockVo.setProductId(omsOrderItem.getProductId());
            reduceStockVo.setReduceQuantity(omsOrderItem.getQuantity());
            reduceStockVos.add(reduceStockVo);
        }
        ReduceStockEvent reduceStockEvent = new ReduceStockEvent();
        String transactionId = UUID.randomUUID().toString();
        reduceStockEvent.setTransactionId(transactionId);
        reduceStockEvent.setOrderId(orderId);
        reduceStockEvent.setReduceStockVos(reduceStockVos);
//        Message<ReduceStockEvent> message = MessageBuilder.withPayload(reduceStockEvent)
//                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
//                        .setHeader("orderId", orderId).build();
        extRocketMQTemplate.convertAndSend("reduce-stock", JSON.toJSONString(reduceStockEvent));
        log.info("sendReduceStockMessage 发送扣减库存消息");
    }

}
