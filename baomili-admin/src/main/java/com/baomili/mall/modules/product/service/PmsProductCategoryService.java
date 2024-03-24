package com.baomili.mall.modules.product.service;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.PmsProductCategoryDto;
import com.baomili.mall.modules.product.dto.ProductCategoryQueryParam;
import com.baomili.mall.modules.product.model.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.product.vo.PmsProductCategoryVo;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {

    int addProductCategory(PmsProductCategoryDto pmsProductCategoryDto);

    int updateProductCategory(PmsProductCategoryDto pmsProductCategoryDto);

    PmsProductCategoryVo getProductCategoryById(Long id);

    PageVo<PmsProductCategory> getPmsProductCategoryPage(ProductCategoryQueryParam queryParam);
}
