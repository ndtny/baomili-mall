package com.baomili.mall.modules.product.rocketmq;

import com.alibaba.fastjson.JSON;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.product.service.PmsStockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "consumerGroup", topic = "reduce-stock")
public class ReduceStockMessageConsumer implements RocketMQListener<String> {

    @Resource
    private PmsStockService pmsStockService;

    @Override
    public void onMessage(String message) {
        log.info("收到扣减库存消息 入参：{}", message);
        ReduceStockEvent reduceStockEvent = JSON.parseObject(message, ReduceStockEvent.class);
        pmsStockService.reduceStock(reduceStockEvent);
    }
}
