package com.baomili.mall.modules.cart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.cart.dto.OmsCartItemDto;
import com.baomili.mall.modules.cart.mapper.OmsCartItemMapper;
import com.baomili.mall.modules.cart.model.OmsCartItem;
import com.baomili.mall.modules.cart.service.OmsCartItemService;
import com.baomili.mall.modules.cart.vo.OmsCartItemVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 订单商品明细 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Service
@Slf4j
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemMapper, OmsCartItem> implements OmsCartItemService {

    @Resource
    private OmsCartItemMapper omsCartItemMapper;

    @Override
    @Transactional
    public int addCart(OmsCartItemDto cartItemDto) {
        log.info("addCart 添加购物车 入参：{}", cartItemDto);
        if (!Optional.ofNullable(cartItemDto.getProductId()).isPresent()) {
            throw new RuntimeException("商品不能为空");
        }
        OmsCartItem omsCartItem = new OmsCartItem();
        BeanUtils.copyProperties(cartItemDto, omsCartItem);
        return omsCartItemMapper.insert(omsCartItem);
    }

    @Override
    @Transactional
    public int updateCart(OmsCartItemDto cartItemDto) {
        log.info("updateCart 更新购物车数量 入参：{}", cartItemDto);
        OmsCartItem omsCartItem = new OmsCartItem();
        omsCartItem.setId(cartItemDto.getId());
        if (cartItemDto.getQuantity() == 0) {
            log.info("updateCart 购物车数量为0 删除");
            omsCartItem.setQuantity(0);
            omsCartItem.setDeleteStatus(true);
            return omsCartItemMapper.updateById(omsCartItem);
        }
        log.info("updateCart 购物车数量不为0 更新数量");
        omsCartItem.setQuantity(cartItemDto.getQuantity());
        return omsCartItemMapper.updateById(omsCartItem);
    }

    @Override
    @Transactional
    public Boolean deleteCart(List<Long> ids) {
        log.info("deleteCart 删除购物车 入参：{}", ids);
        List<OmsCartItem> omsCartItems = new ArrayList<>();
        for (Long id : ids) {
            OmsCartItem omsCartItem = new OmsCartItem();
            omsCartItem.setId(id);
            omsCartItem.setDeleteStatus(true);
            omsCartItems.add(omsCartItem);
        }
        return this.updateBatchById(omsCartItems);
    }

    @Override
    public List<OmsCartItemVo> getCartList() {
        QueryWrapper<OmsCartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delete_status", 0);
        List<OmsCartItem> omsCartItems = omsCartItemMapper.selectList(queryWrapper);
        List<OmsCartItemVo> omsCartItemVos = new ArrayList<>();
        for (OmsCartItem omsCartItem : omsCartItems) {
            OmsCartItemVo omsCartItemVo = new OmsCartItemVo();
            BeanUtils.copyProperties(omsCartItem, omsCartItemVo);
            omsCartItemVos.add(omsCartItemVo);
        }
        return omsCartItemVos;
    }
}
