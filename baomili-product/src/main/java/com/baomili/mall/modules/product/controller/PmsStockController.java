package com.baomili.mall.modules.product.controller;


import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.product.model.PmsStock;
import com.baomili.mall.modules.product.service.PmsStockService;
import com.baomili.mall.modules.product.vo.PmsStockVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.PublicKey;
import java.util.List;

/**
 * <p>
 * 商品库存 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/product/pmsStock")
public class PmsStockController {

    @Resource
    private PmsStockService pmsStockService;

    @ApiOperation("查询商品库存")
    @RequestMapping(value = "/getProductStock", method = RequestMethod.POST)
    public CommonResult<List<PmsStockVo>> getProductStock(@RequestBody List<Long> productIds) {
        List<PmsStockVo> pmsStockVos = pmsStockService.getProductStock(productIds);
        return CommonResult.success(pmsStockVos);
    }

    @ApiOperation("恢复商品库存")
    @RequestMapping(value = "/recoverStock", method = RequestMethod.POST)
    public CommonResult recoverStock(@RequestBody List<ReduceStockVo> reduceStockVos) {
        pmsStockService.recoverStock(reduceStockVos);
        return CommonResult.success();
    }

}

