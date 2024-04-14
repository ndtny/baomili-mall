package com.baomili.mall.modules.product.rocketmq;

import com.baomili.mall.modules.product.service.PmsStockService;
import com.baomili.mall.modules.product.vo.rocketmq.ReduceStockEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "reduce-stock")
public class ReduceStockMessageConsumer implements RocketMQListener<ReduceStockEvent> {

    @Resource
    private PmsStockService pmsStockService;

    @Override
    public void onMessage(ReduceStockEvent reduceStockEvent) {
        log.info("收到扣减库存消息 入参：{}", reduceStockEvent);
        pmsStockService.reduceStock(reduceStockEvent);
    }
}
