package com.baomili.mall.modules.product.controller;


import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.PmsProductDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsProduct;
import com.baomili.mall.modules.product.service.PmsProductService;
import com.baomili.mall.modules.product.vo.PmsProductVo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.peer.CanvasPeer;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/product/pmsProduct")
public class PmsProductController {

    @Resource
    private PmsProductService pmsProductService;

    @ApiOperation("新增商品")
    @PostMapping("/addProduct")
    public CommonResult<Integer> addProduct(@RequestBody PmsProductDto pmsProductDto) {
        int count = pmsProductService.addProduct(pmsProductDto);
        if (count == 1) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改商品")
    @PostMapping("/updateProduct")
    public CommonResult<Integer> updateProduct(@RequestBody PmsProductDto pmsProductDto) {
        int count = pmsProductService.updateProduct(pmsProductDto);
        if (count == 1) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页查询商品信息")
    @PostMapping("/getProductPage")
    public CommonResult<PageVo<PmsProduct>> getProductPage(@RequestBody ProductQueryParam param) {
        PageVo<PmsProduct> pageVo = pmsProductService.getProductPage(param);
        return CommonResult.success(pageVo);
    }

    @ApiOperation("查询单个商品信息")
    @PostMapping("/getProductById")
    public CommonResult<PmsProductVo> getProductById(@RequestParam Long id) {
        PmsProductVo pmsProductVo = pmsProductService.getProductById(id);
        return CommonResult.success(pmsProductVo);
    }
}

