package com.baomili.mall.modules.cart.controller;


import com.baomili.mall.modules.cart.dto.OmsCartItemDto;
import com.baomili.mall.modules.cart.service.OmsCartItemService;
import com.baomili.mall.modules.cart.vo.OmsCartItemVo;
import com.baomili.mall.modules.common.api.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单购物车表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@RestController
@RequestMapping("/order/omsCartItem")
public class OmsCartItemController {

    @Resource
    private OmsCartItemService omsCartItemService;

    @ApiOperation("加入购物车")
    @PostMapping("/addCart")
    public CommonResult<Integer> addCart(@RequestBody OmsCartItemDto cartItemDto) {
        int count = omsCartItemService.addCart(cartItemDto);
        if (count == 1) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("购物车商品数量修改")
    @PostMapping("/updateCart")
    public CommonResult<Integer> updateCart(@RequestBody OmsCartItemDto cartItemDto) {
        int count = omsCartItemService.updateCart(cartItemDto);
        if (count == 1) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除购物车")
    @PostMapping("/deleteCart")
    public CommonResult<Boolean> deleteCart(@RequestBody List<Long> ids) {
        return CommonResult.success(omsCartItemService.deleteCart(ids));
    }

    @ApiOperation("购物车列表查询")
    @PostMapping("/getCartList")
    public CommonResult<List<OmsCartItemVo>> getCartList() {
        return CommonResult.success(omsCartItemService.getCartList());
    }

}

