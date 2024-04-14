package com.baomili.mall.modules.order.vo.rocketmq;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReduceStockVo implements Serializable {

    private static final long serialVersionUID = -2220465306184217883L;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 扣减数量
     */
    private Integer reduceQuantity;
}
