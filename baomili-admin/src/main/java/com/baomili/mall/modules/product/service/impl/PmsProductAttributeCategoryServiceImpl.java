package com.baomili.mall.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeCategoryQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductAttributeCategoryDto;
import com.baomili.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomili.mall.modules.product.mapper.PmsProductAttributeCategoryMapper;
import com.baomili.mall.modules.product.service.PmsProductAttributeCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.product.vo.PmsProductAttributeCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {

    @Resource
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

    @Override
    public int addAttributeCategory(PmsProductAttributeCategoryDto attributeCategoryDto) {
        log.info("addAttributeCategory 新增商品属性分类 入参：{}", attributeCategoryDto);
        if (StringUtils.isBlank(attributeCategoryDto.getName())) {
            throw new RuntimeException("商品属性分类名称不能为空");
        }
        QueryWrapper<PmsProductAttributeCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", attributeCategoryDto.getName());
        PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryMapper.selectOne(queryWrapper);
        log.info("addAttributeCategory 新增商品属性分类 是否已存在：{}", pmsProductAttributeCategory);
        if (Optional.ofNullable(pmsProductAttributeCategory).isPresent()) {
            throw new RuntimeException("该商品属性分类已存在");
        }

        PmsProductAttributeCategory attributeCategory = new PmsProductAttributeCategory();
        BeanUtils.copyProperties(attributeCategoryDto, attributeCategory);
        return pmsProductAttributeCategoryMapper.insert(attributeCategory);
    }

    @Override
    public int updateAttributeCategory(PmsProductAttributeCategoryDto attributeCategoryDto) {
        log.info("updateAttributeCategory 修改商品属性分类 入参：{}", attributeCategoryDto);
        PmsProductAttributeCategory attributeCategory = new PmsProductAttributeCategory();
        BeanUtils.copyProperties(attributeCategoryDto, attributeCategory);
        return pmsProductAttributeCategoryMapper.updateById(attributeCategory);
    }

    @Override
    public PageVo<PmsProductAttributeCategory> getPageList(AttributeCategoryQueryParam attributeCategoryQueryParam) {
        log.info("getPageList 分页查询属性分类 入参：{}", attributeCategoryQueryParam);
        QueryWrapper<PmsProductAttributeCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delete_status", 0);
        if (StringUtils.isNotBlank(attributeCategoryQueryParam.getName())) {
            queryWrapper.likeRight("name", attributeCategoryQueryParam.getName());
        }
        List<PmsProductAttributeCategory> list = pmsProductAttributeCategoryMapper.selectList(queryWrapper);
        log.info("getPageList 分页查询属性分类 total：{}", list.size());
        return new PageVo<>(attributeCategoryQueryParam.getCurrent(), attributeCategoryQueryParam.getPageSize(), list.size(), list);
    }

    @Override
    public PmsProductAttributeCategoryVo getAttributeCategoryById(Long id) {
        log.info("getAttributeCategoryById 查询属性分类信息 入参：{}", id);
        QueryWrapper<PmsProductAttributeCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        PmsProductAttributeCategory attributeCategory = pmsProductAttributeCategoryMapper.selectOne(queryWrapper);
        PmsProductAttributeCategoryVo attributeCategoryVo = new PmsProductAttributeCategoryVo();
        BeanUtils.copyProperties(attributeCategory, attributeCategoryVo);
        log.info("getAttributeCategoryById 查询属性分类信息 结果：{}", attributeCategoryVo);
        return attributeCategoryVo;
    }
}
