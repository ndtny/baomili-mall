package com.baomili.mall.modules.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.service.PmsBrandService;
import com.baomili.mall.modules.product.vo.PmsBrandVo;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/product/pmsBrand")
public class PmsBrandController {

    @Resource
    private PmsBrandService pmsBrandService;

    @ApiOperation("新增商品品牌")
    @PostMapping("/addPmsBrand")
    public CommonResult<Integer> addPmsBrand(@RequestBody PmsBrandDto brandDto) {
        int count = pmsBrandService.addPmsBrand(brandDto);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改商品品牌")
    @PostMapping("/updatePmsBrand")
    public CommonResult<Integer> updatePmsBrand(@RequestBody PmsBrandDto brandDto) {
        int count = pmsBrandService.updatePmsBrand(brandDto);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("查询单个品牌信息")
    @GetMapping("/info")
    public CommonResult<PmsBrandVo> getBrandVoById(@RequestParam Long id) {
        PmsBrandVo pmsBrandVo = pmsBrandService.getBrandVoById(id);
        return CommonResult.success(pmsBrandVo);
    }

    @ApiOperation("品牌分页列表")
    @PostMapping("/getPmsBrandPage")
    public CommonResult<PageVo<PmsBrand>> getPmsBrandPage(@RequestBody BrandQueryParam queryParam) {
        PageVo<PmsBrand> page = pmsBrandService.getPmsBrandPage(queryParam);
        return CommonResult.success(page);
    }
}

