package com.baomili.mall.modules.order.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * 一个事物监听器对应一个事物流程
 */
@Slf4j
@RocketMQTransactionListener(rocketMQTemplateBeanName="extRocketMQTemplate")
public class ReduceStockMessageListener implements RocketMQLocalTransactionListener {

    /**
     * 事务消息发送后的回调方法，当消息发送给mq成功，此方法被回调
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        
        try {
//            String transactionId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
            // 模拟查询库存是否充足
            if (arg != null) {
                //当返回RocketMQLocalTransactionState.COMMIT，自动向mq发送commit消息，mq将消息的状态改为可消费
                log.info("向mq发送commit消息，mq将消息的状态改为可消费");
                return RocketMQLocalTransactionState.COMMIT;
            }
            log.info("向mq发送rollback消息，mq将消息的状态改为回滚");
            return RocketMQLocalTransactionState.ROLLBACK;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
    
    /**
     * 事务状态回查
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {

        String transactionId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        int existTx = 1;
        if (existTx > 0) {
            log.info("事务状态回查 向mq发送commit消息，mq将消息的状态改为可消费");
            return RocketMQLocalTransactionState.COMMIT;
        } else {
            log.info("事务状态回查 向mq发送rollback消息，mq将消息的状态改为回滚");
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }
}
