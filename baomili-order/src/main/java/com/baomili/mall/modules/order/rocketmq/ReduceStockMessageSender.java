package com.baomili.mall.modules.order.rocketmq;

import cn.hutool.core.lang.UUID;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomili.mall.modules.order.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.order.vo.rocketmq.ReduceStockVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
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
    private RocketMQTemplate rocketMQTemplate;

    public Boolean sendReduceStockMessage(Long orderId, List<OmsOrderItem> omsOrderItems) {
        log.info("sendReduceStockMessage 发送扣减库存消息 入参：{} {}", orderId, omsOrderItems);
        List<ReduceStockVo> reduceStockVos = new ArrayList<>();
        for (OmsOrderItem omsOrderItem : omsOrderItems) {
            ReduceStockVo reduceStockVo = new ReduceStockVo();
            reduceStockVo.setProductId(omsOrderItem.getProductId());
            reduceStockVo.setReduceQuantity(omsOrderItem.getQuantity());
            reduceStockVos.add(reduceStockVo);
        }
        ReduceStockEvent reduceStockEvent = new ReduceStockEvent();
        reduceStockEvent.setTransactionId(UUID.randomUUID().toString());
        reduceStockEvent.setOrderId(orderId);
        reduceStockEvent.setReduceStockVos(reduceStockVos);
        Message<ReduceStockEvent> message = MessageBuilder.withPayload(reduceStockEvent)
                        .setHeader("orderId", orderId).build();
        TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction("reduce-stock", message, orderId);
        boolean result = SendStatus.SEND_OK.equals(sendResult.getSendStatus());
        log.info("sendReduceStockMessage 发送扣减库存消息 结果：{}", result);
        return result;
    }

}
