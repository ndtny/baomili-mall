package com.baomili.mall.modules.order.mapper;

import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单商品明细 Mapper 接口
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Mapper
public interface OmsOrderItemMapper extends BaseMapper<OmsOrderItem> {

    List<OmsOrderItem> getOrderItemListByOrderIds(@Param("orderIds") List<Long> orderIds);
}
