package com.baomili.mall;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RocketMQTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendNormalMessage() throws Exception {
        // 初始化消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("test");
        // 指定nameserver地址
        producer.setNamesrvAddr("47.101.135.230:9876");
        // 启动消息生产者服务，构建消息
        producer.start();
        log.info("producer start");
        for (int i = 0; i < 2; i++) {
            // 创建消息，消息由topic、tag、body构成
            Message message = new Message("test", "test-tag", ("Hello World" + i).getBytes());
            // 发送消息
            try {
                SendResult sendResult = producer.send(message);
                log.info("sendResult:{}", sendResult);
            } catch (Exception e) {
                log.error("发送消息失败：{}", e.getMessage());
            }
        }
        producer.shutdown();
        log.info("producer shutdown");
    }

    @Test
    public void receiveMessage() throws Exception {
        // 初始化消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test");
        // 指定nameserver
        consumer.setNamesrvAddr("47.101.135.230:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        // 订阅topic
        consumer.subscribe("test", "*");
        // 注册消息回调函数，消费消息时触发
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                log.info("消息消费回调:{}",list);
                list.forEach(message -> {
                    try {
                        log.info("收到消息:{}, {}", new String(message.getBody()), RemotingHelper.DEFAULT_CHARSET);
                    } catch (Exception e) {
                        log.error("消费消息异常：{}", e.getMessage());
                    }
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        log.info("consumer start");
    }

    @Test
    public void sendDelayMessage() throws Exception {
        Long deliverTimeStamp = System.currentTimeMillis() + 60 * 1000;
        // 初始化消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("DelayTopicProducer");
        // 指定nameserver地址
        producer.setNamesrvAddr("47.101.135.230:9876");
        // 启动消息生产者服务，构建消息
        producer.start();
        log.info("producer start");
        for (int i = 0; i < 2; i++) {
            // 创建消息，消息由topic、tag、body构成
            Message message = new Message("DelayTopic", "delay-tag", ("Hello World" + i).getBytes());
            // 发送消息
            try {
                SendResult sendResult = producer.send(message, deliverTimeStamp);
                log.info("sendResult:{}", sendResult);
            } catch (Exception e) {
                log.error("发送消息失败：{}", e.getMessage());
            }
        }
        producer.shutdown();
        log.info("producer shutdown");
    }

    @Test
    public void receiveDelayMessage() throws Exception {
        // 初始化消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("DelayTopicConsumer");
        // 指定nameserver
        consumer.setNamesrvAddr("47.101.135.230:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        // 订阅topic
        consumer.subscribe("DelayTopic", "*");
        // 注册消息回调函数，消费消息时触发
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                log.info("消息消费回调:{}",list);
                list.forEach(message -> {
                    try {
                        log.info("收到消息:{}, {}", new String(message.getBody()), RemotingHelper.DEFAULT_CHARSET);
                    } catch (Exception e) {
                        log.error("消费消息异常：{}", e.getMessage());
                    }
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        log.info("consumer start");
    }
}
