package com.baomili.mall.modules.order.rocketmq;

import com.baomili.mall.modules.order.service.OmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class OrderTimeOutCancelTask {

    @Resource
    private OmsOrderService omsOrderService;

    /**
     * MQ取消订单的补偿机制（防止出现意外等问题遗漏）
     */
    @Scheduled(cron = "0 0/2 * ? * ?")
    public void orderTimeOutCancel() {
        omsOrderService.orderTimeOutCancel();
    }
}
