package com.baomili.mall.modules.product.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@DS("pms")
public interface PmsProductCategoryMapper extends BaseMapper<PmsProductCategory> {

}
