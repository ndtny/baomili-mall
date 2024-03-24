package com.baomili.mall.modules.product.controller;


import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeQueryParam;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductAttributeDto;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.model.PmsProductAttribute;
import com.baomili.mall.modules.product.service.PmsProductAttributeService;
import com.baomili.mall.modules.product.vo.PmsBrandVo;
import com.baomili.mall.modules.product.vo.PmsProductAttributeVo;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品属性参数表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/product/pmsProductAttribute")
public class PmsProductAttributeController {

    @Resource
    private PmsProductAttributeService pmsProductAttributeService;

    @ApiOperation("新增商品属性")
    @PostMapping("/addAttribute")
    public CommonResult<Integer> addAttribute(@RequestBody PmsProductAttributeDto pmsProductAttributeDto) {
        int count = pmsProductAttributeService.addAttribute(pmsProductAttributeDto);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改商品属性")
    @PostMapping("/updateAttribute")
    public CommonResult<Integer> updateAttribute(@RequestBody PmsProductAttributeDto pmsProductAttributeDto) {
        int count = pmsProductAttributeService.updateAttribute(pmsProductAttributeDto);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("查询单个商品属性信息")
    @GetMapping("/info")
    public CommonResult<PmsProductAttributeVo> getAttributeById(@RequestParam Long id) {
        PmsProductAttributeVo pmsProductAttributeVo = pmsProductAttributeService.getAttributeById(id);
        return CommonResult.success(pmsProductAttributeVo);
    }

    @ApiOperation("商品属性分页列表")
    @PostMapping("/getPmsAttributePage")
    public CommonResult<PageVo<PmsProductAttribute>> getPmsAttributePage(@RequestBody AttributeQueryParam queryParam) {
        PageVo<PmsProductAttribute> page = pmsProductAttributeService.getPmsAttributePage(queryParam);
        return CommonResult.success(page);
    }
}


