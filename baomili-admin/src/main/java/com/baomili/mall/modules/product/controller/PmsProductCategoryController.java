package com.baomili.mall.modules.product.controller;


import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductCategoryDto;
import com.baomili.mall.modules.product.dto.ProductCategoryQueryParam;
import com.baomili.mall.modules.product.model.PmsProductAttribute;
import com.baomili.mall.modules.product.model.PmsProductCategory;
import com.baomili.mall.modules.product.service.PmsProductCategoryService;
import com.baomili.mall.modules.product.vo.PmsProductAttributeVo;
import com.baomili.mall.modules.product.vo.PmsProductCategoryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品分类表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/product/pmsProductCategory")
public class PmsProductCategoryController {

    @Resource
    private PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation("新增商品分类")
    @PostMapping("/addProductCategory")
    public CommonResult<Integer> addProductCategory(@RequestBody PmsProductCategoryDto pmsProductCategoryDto) {
        int count = pmsProductCategoryService.addProductCategory(pmsProductCategoryDto);
        if (count == 1) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改商品分类")
    @PostMapping("/updateProductCategory")
    public CommonResult<Integer> updateProductCategory(@RequestBody PmsProductCategoryDto pmsProductCategoryDto) {
        int count = pmsProductCategoryService.updateProductCategory(pmsProductCategoryDto);
        if (count == 1) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("查询单个商品分类信息")
    @GetMapping("/info")
    public CommonResult<PmsProductCategoryVo> getProductCategoryById(@RequestParam Long id) {
        PmsProductCategoryVo pmsProductCategoryVo = pmsProductCategoryService.getProductCategoryById(id);
        return CommonResult.success(pmsProductCategoryVo);
    }

    @ApiOperation("商品分类分页列表")
    @PostMapping("/getPmsProductCategoryPage")
    public CommonResult<PageVo<PmsProductCategory>> getPmsProductCategoryPage(@RequestBody ProductCategoryQueryParam queryParam) {
        PageVo<PmsProductCategory> page = pmsProductCategoryService.getPmsProductCategoryPage(queryParam);
        return CommonResult.success(page);
    }
}

