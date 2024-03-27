package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.PmsProductCategoryDto;
import com.baomili.mall.modules.product.dto.ProductCategoryQueryParam;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.model.PmsProductCategory;
import com.baomili.mall.modules.product.mapper.PmsProductCategoryMapper;
import com.baomili.mall.modules.product.model.PmsProductCategoryAttributeRelation;
import com.baomili.mall.modules.product.service.PmsProductCategoryAttributeRelationService;
import com.baomili.mall.modules.product.service.PmsProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.product.vo.PmsProductCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {

    @Resource
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @Resource
    private PmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    @Override
    @Transactional
    @DS("pms")
    public int addProductCategory(PmsProductCategoryDto pmsProductCategoryDto) {
        log.info("addProductCategory 新增商品分类 入参：{}", pmsProductCategoryDto);
        if (StringUtils.isBlank(pmsProductCategoryDto.getName())) {
            throw new RuntimeException("商品分类名称不能为空");
        }
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",pmsProductCategoryDto.getName());
        PmsProductCategory productCategory = pmsProductCategoryMapper.selectOne(queryWrapper);
        log.info("addProductCategory 新增商品分类 是否已存在：{}", productCategory);
        if (Optional.ofNullable(productCategory).isPresent()) {
            throw new RuntimeException("商品分类已存在");
        }
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryDto, pmsProductCategory);
        int count = pmsProductCategoryMapper.insert(pmsProductCategory);
        log.info("addProductCategory 新增商品分类 成功");
        if (CollectionUtils.isNotEmpty(pmsProductCategoryDto.getProductAttributeIds())) {
            log.info("addProductCategory 新增商品分类 绑定了商品属性");
            insertPmsProductCategoryAttributeRelation(pmsProductCategoryDto, pmsProductCategory);
            log.info("addProductCategory 新增商品分类 绑定商品属性成功");
        }
        return count;
    }

    @Override
    public int updateProductCategory(PmsProductCategoryDto pmsProductCategoryDto) {
        log.info("updateProductCategory 修改商品分类 入参：{}", pmsProductCategoryDto);
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryDto, pmsProductCategory);
        int count = pmsProductCategoryMapper.updateById(pmsProductCategory);
        log.info("updateProductCategory 修改商品分类 成功");
        if (CollectionUtils.isNotEmpty(pmsProductCategoryDto.getProductAttributeIds())) {
            log.info("addProductCategory 修改商品分类 绑定了商品属性");
            // 先删再新增，判断新增还是删除了很麻烦
            deletePmsProductCategoryAttributeRelation(pmsProductCategoryDto);
            insertPmsProductCategoryAttributeRelation(pmsProductCategoryDto, pmsProductCategory);
            log.info("updateProductCategory 修改商品分类 绑定商品属性成功");
        } else {
            log.info("updateProductCategory 修改商品分类 删除商品属性成功");
            deletePmsProductCategoryAttributeRelation(pmsProductCategoryDto);
        }
        return count;
    }

    private void insertPmsProductCategoryAttributeRelation(PmsProductCategoryDto pmsProductCategoryDto, PmsProductCategory pmsProductCategory) {
        List<PmsProductCategoryAttributeRelation> relations = new ArrayList<>();
        for (Long productAttributeId : pmsProductCategoryDto.getProductAttributeIds()) {
            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
            relation.setProductCategoryId(pmsProductCategory.getId());
            relation.setProductAttributeId(productAttributeId);
            relations.add(relation);
        }
        pmsProductCategoryAttributeRelationService.saveBatch(relations);
    }

    private void deletePmsProductCategoryAttributeRelation(PmsProductCategoryDto pmsProductCategoryDto) {
        UpdateWrapper<PmsProductCategoryAttributeRelation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_category_id", pmsProductCategoryDto.getId());
        updateWrapper.eq("delete_status", 0);
        updateWrapper.set("delete_status", 1);
        pmsProductCategoryAttributeRelationService.update(updateWrapper);
    }

    @Override
    public PmsProductCategoryVo getProductCategoryById(Long id) {
        log.info("getProductCategoryById 查询商品分类信息 入参：{}", id);
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        PmsProductCategory pmsProductCategory = pmsProductCategoryMapper.selectOne(queryWrapper);

        PmsProductCategoryVo pmsProductCategoryVo = new PmsProductCategoryVo();
        BeanUtils.copyProperties(pmsProductCategory, pmsProductCategoryVo);

        QueryWrapper<PmsProductCategoryAttributeRelation> relationQueryWrapper = new QueryWrapper<>();
        relationQueryWrapper.eq("product_category_id", pmsProductCategory.getId());
        List<PmsProductCategoryAttributeRelation> relations = pmsProductCategoryAttributeRelationService.list(relationQueryWrapper);
        if (CollectionUtils.isNotEmpty(relations)) {
            log.info("getProductCategoryById 查询商品分类信息 存在关联属性信息");
            List<Long> attributeIds = relations.stream().map(PmsProductCategoryAttributeRelation::getProductAttributeId).collect(Collectors.toList());
            pmsProductCategoryVo.setProductAttributeIds(attributeIds);
        }
        return pmsProductCategoryVo;
    }

    @Override
    public PageVo<PmsProductCategory> getPmsProductCategoryPage(ProductCategoryQueryParam queryParam) {
        log.info("getPmsProductCategoryPage 分页查询商品分类信息 入参：{}", queryParam);
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delete_status", 0);
        if (StringUtils.isNotBlank(queryParam.getName())) {
            queryWrapper.likeRight("name", queryParam.getName());
        }
        Page<PmsProductCategory> page = new Page<>();
        page.setCurrent(queryParam.getCurrent());
        page.setSize(queryParam.getPageSize());
        Page<PmsProductCategory> productCategoryPage = pmsProductCategoryMapper.selectPage(page, queryWrapper);
        return new PageVo<>(productCategoryPage.getCurrent(), productCategoryPage.getSize(), productCategoryPage.getTotal(), productCategoryPage.getRecords());
    }
}
