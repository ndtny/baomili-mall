package com.baomili.mall.modules.product.service;

import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.product.model.PmsStock;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.product.vo.PmsStockVo;

import java.util.List;

/**
 * <p>
 * 商品库存 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface PmsStockService extends IService<PmsStock> {

    void reduceStock(ReduceStockEvent reduceStockEvent);

    List<PmsStockVo> getProductStock(List<Long> productIds);

    void recoverStock(List<ReduceStockVo> reduceStockVos);
}
