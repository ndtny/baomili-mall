package com.baomili.mall;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SpringBootRocketMQTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendMessage() {
        log.info("发送消息");
        rocketMQTemplate.convertAndSend("test", "hello world");
        log.info("发送消息成功");
    }
}
