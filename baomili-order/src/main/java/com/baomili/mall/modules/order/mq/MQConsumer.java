package com.baomili.mall.modules.order.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
    import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "consumerGroup", topic =
        "test",consumeMode= ConsumeMode.CONCURRENTLY,messageModel=
        MessageModel.BROADCASTING)
@Slf4j
public class MQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("接收消息：{}", message);
    }
}
