package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsProductCategoryAttributeRelation;
import com.baomili.mall.modules.product.mapper.PmsProductCategoryAttributeRelationMapper;
import com.baomili.mall.modules.product.service.PmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@DS("pms")
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}
