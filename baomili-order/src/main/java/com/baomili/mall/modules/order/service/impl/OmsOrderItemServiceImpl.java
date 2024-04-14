package com.baomili.mall.modules.order.service.impl;

import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomili.mall.modules.order.mapper.OmsOrderItemMapper;
import com.baomili.mall.modules.order.service.OmsOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单商品明细 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService {

    @Resource
    private OmsOrderItemMapper omsOrderItemMapper;

    @Override
    public List<OmsOrderItem> getOrderItemListByOrderIds(List<Long> orderIds) {
        return omsOrderItemMapper.getOrderItemListByOrderIds(orderIds);
    }
}
