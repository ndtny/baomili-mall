package com.baomili.mall.modules.order.rocketmq;

import cn.hutool.core.lang.UUID;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderCancelMessageSender {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public boolean sendOrderCancelMessage(List<Long> orderIds, Integer delayTimes) {
        log.info("sendOrderCancelMessage 超时取消订单 入参：{}", orderIds);
        Message<List<Long>> message = MessageBuilder.withPayload(orderIds).build();
        SendResult sendResult = rocketMQTemplate.syncSend("order-cancel", message, 5000, delayTimes);
        boolean result = SendStatus.SEND_OK.equals(sendResult.getSendStatus());
        log.info("sendOrderCancelMessage 超时取消订单 结果：{}", result);
        return result;
    }

}
