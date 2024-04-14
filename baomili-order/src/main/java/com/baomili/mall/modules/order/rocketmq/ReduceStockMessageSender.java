package com.baomili.mall.modules.order.rocketmq;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionSendResult;
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

    public boolean sendReduceStockMessage(List<OmsOrderItem> omsOrderItems) {
        log.info("sendReduceStockMessage 发送扣减库存消息 入参：{}", omsOrderItems);
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
        reduceStockEvent.setReduceStockVos(reduceStockVos);
        Message<ReduceStockEvent> message = MessageBuilder.withPayload(reduceStockEvent)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId).build();
        TransactionSendResult sendResult = extRocketMQTemplate.sendMessageInTransaction("reduce-stock", message, transactionId);
        boolean result = LocalTransactionState.COMMIT_MESSAGE.equals(sendResult.getLocalTransactionState());
        if (result) {
            result = SendStatus.SEND_OK.equals(sendResult.getSendStatus());
        }
        log.info("sendReduceStockMessage 发送扣减库存消息 结果：{}", result);
        return result;
    }

}
