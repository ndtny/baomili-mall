package com.baomili.mall.modules.product.mapper;

import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.product.model.PmsStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomili.mall.modules.product.vo.PmsStockVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品库存 Mapper 接口
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Mapper
public interface PmsStockMapper extends BaseMapper<PmsStock> {

    int isExistTx(@Param("transactionId") String transactionId);

    void reducePmsStock(@Param("reduceStockVos") List<ReduceStockVo> reduceStockVos);

    List<PmsStockVo> getProductStock(@Param("productIds") List<Long> productIds);

    void recoverPmsStock(@Param("reduceStockVos")List<ReduceStockVo> reduceStockVos);
}
