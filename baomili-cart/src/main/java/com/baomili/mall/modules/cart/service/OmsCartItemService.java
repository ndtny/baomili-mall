package com.baomili.mall.modules.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.cart.dto.OmsCartItemDto;
import com.baomili.mall.modules.cart.model.OmsCartItem;
import com.baomili.mall.modules.cart.vo.OmsCartItemVo;

import java.util.List;

/**
 * <p>
 * 订单购物车表 服务类
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
public interface OmsCartItemService extends IService<OmsCartItem> {

    int addCart(OmsCartItemDto cartItemDto);

    int updateCart(OmsCartItemDto cartItemDto);

    Boolean deleteCart(List<Long> ids);

    List<OmsCartItemVo> getCartList();
}
