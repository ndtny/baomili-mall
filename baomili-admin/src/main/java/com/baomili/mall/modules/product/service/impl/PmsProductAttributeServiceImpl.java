package com.baomili.mall.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductAttributeDto;
import com.baomili.mall.modules.product.model.PmsProductAttribute;
import com.baomili.mall.modules.product.mapper.PmsProductAttributeMapper;
import com.baomili.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomili.mall.modules.product.model.PmsProductCategoryAttributeRelation;
import com.baomili.mall.modules.product.service.PmsProductAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.product.service.PmsProductCategoryAttributeRelationService;
import com.baomili.mall.modules.product.vo.PmsProductAttributeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeMapper, PmsProductAttribute> implements PmsProductAttributeService {

    @Resource
    private PmsProductAttributeMapper pmsProductAttributeMapper;

    @Resource
    private PmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    @Override
    public int addAttribute(PmsProductAttributeDto pmsProductAttributeDto) {
        log.info("addAttribute 新增商品属性 入参：{}", pmsProductAttributeDto);
        if (StringUtils.isBlank(pmsProductAttributeDto.getAttributeName())) {
            throw new RuntimeException("商品属性名称不能为空");
        }
        if (!Optional.ofNullable(pmsProductAttributeDto.getProductAttributeCategoryId()).isPresent()) {
            throw new RuntimeException("商品属性分类不能为空");
        }
        QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attribute_name", pmsProductAttributeDto.getAttributeName());
        PmsProductAttribute attribute = pmsProductAttributeMapper.selectOne(queryWrapper);
        log.info("addAttribute 新增商品属性 是否已存在：{}", attribute);
        if (Optional.ofNullable(attribute).isPresent()) {
            throw new RuntimeException("该商品属性已存在");
        }
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeDto, pmsProductAttribute);
        return pmsProductAttributeMapper.insert(pmsProductAttribute);
    }

    @Override
    public int updateAttribute(PmsProductAttributeDto pmsProductAttributeDto) {
        log.info("updateAttribute 修改商品属性 入参：{}", pmsProductAttributeDto);
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeDto, pmsProductAttribute);
        return pmsProductAttributeMapper.updateById(pmsProductAttribute);
    }

    @Override
    public PmsProductAttributeVo getAttributeById(Long id) {
        log.info("getAttributeById 查询商品属性 入参：{}", id);
        QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeMapper.selectOne(queryWrapper);
        PmsProductAttributeVo pmsProductAttributeVo = new PmsProductAttributeVo();
        BeanUtils.copyProperties(pmsProductAttribute, pmsProductAttributeVo);
        log.info("getAttributeById 查询商品属性 结果：{}", pmsProductAttributeVo);
        return pmsProductAttributeVo;
    }

    @Override
    public PageVo<PmsProductAttribute> getPmsAttributePage(AttributeQueryParam queryParam) {
        log.info("getPmsAttributePage 分页查询商品属性 入参：{}", queryParam);
        QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delete_status", 0);
        if (StringUtils.isNotBlank(queryParam.getAttributeName())) {
            queryWrapper.eq("attribute_name", queryParam.getAttributeName());
        }
        Page<PmsProductAttribute> page = new Page<>();
        page.setCurrent(queryParam.getCurrent());
        page.setSize(queryParam.getPageSize());
        Page<PmsProductAttribute> attributePage = pmsProductAttributeMapper.selectPage(page, queryWrapper);
        return new PageVo<>(attributePage.getCurrent(), attributePage.getSize(), attributePage.getTotal(), attributePage.getRecords());
    }
}
