package com.baomili.mall.modules.order.service;

import com.baomili.mall.modules.order.dto.OmsOrderDto;
import com.baomili.mall.modules.order.dto.OrderQueryParamDto;
import com.baomili.mall.modules.order.model.OmsOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.order.vo.OmsOrderVo;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
public interface OmsOrderService extends IService<OmsOrder> {

    void addOrder(OmsOrderDto omsOrderDto);

    List<OmsOrderVo> getOrderList(OrderQueryParamDto queryParamDto);

    void orderTimeOutCancel();
}
