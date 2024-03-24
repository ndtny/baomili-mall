package com.baomili.mall.modules.product.controller;


import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeCategoryQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.PmsProductAttributeCategoryDto;
import com.baomili.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomili.mall.modules.product.service.PmsProductAttributeCategoryService;
import com.baomili.mall.modules.product.vo.PmsProductAttributeCategoryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/product/pmsProductAttributeCategory")
public class PmsProductAttributeCategoryController {

    @Resource
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @ApiOperation("新增属性分类")
    @PostMapping("/addAttributeCategory")
    public CommonResult<Integer> addAttributeCategory(@RequestBody PmsProductAttributeCategoryDto attributeCategoryDto) {
        int count = pmsProductAttributeCategoryService.addAttributeCategory(attributeCategoryDto);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改属性分类")
    @PostMapping("/updateAttributeCategory")
    public CommonResult<Integer> updateAttributeCategory(@RequestBody PmsProductAttributeCategoryDto attributeCategoryDto) {
        int count = pmsProductAttributeCategoryService.updateAttributeCategory(attributeCategoryDto);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("属性分类分页列表")
    @PostMapping("/getPageList")
    public CommonResult<PageVo<PmsProductAttributeCategory>> getPageList(@RequestBody AttributeCategoryQueryParam attributeCategoryQueryParam) {
       PageVo<PmsProductAttributeCategory> pageVo = pmsProductAttributeCategoryService.getPageList(attributeCategoryQueryParam);
       return CommonResult.success(pageVo);
    }

    @ApiOperation("查询单个属性分类信息")
    @GetMapping("/info")
    public CommonResult<PmsProductAttributeCategoryVo> getAttributeCategoryById(@RequestParam Long id) {
        PmsProductAttributeCategoryVo attributeCategoryVo = pmsProductAttributeCategoryService.getAttributeCategoryById(id);
        return CommonResult.success(attributeCategoryVo);
    }

}

