package com.baomili.mall.modules.product.service;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeCategoryQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductAttributeCategoryDto;
import com.baomili.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.product.vo.PmsProductAttributeCategoryVo;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {

    int addAttributeCategory(PmsProductAttributeCategoryDto attributeCategoryDto);

    int updateAttributeCategory(PmsProductAttributeCategoryDto attributeCategoryDto);

    PageVo<PmsProductAttributeCategory> getPageList(AttributeCategoryQueryParam attributeCategoryQueryParam);

    PmsProductAttributeCategoryVo getAttributeCategoryById(Long id);
}
