package com.baomili.mall.modules.common.vo.rocketmq;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReduceStockEvent implements Serializable {
    private static final long serialVersionUID = 6166643989627271605L;

    /**
     * 事务id（幂等校验）
     */
    private String transactionId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 扣减库存明细
     */
    private List<ReduceStockVo> reduceStockVos;
}
