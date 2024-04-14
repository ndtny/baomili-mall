package com.baomili.mall.modules.order.service;

import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单商品明细 服务类
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
public interface OmsOrderItemService extends IService<OmsOrderItem> {

    List<OmsOrderItem> getOrderItemListByOrderIds(List<Long> orderIds);
}
