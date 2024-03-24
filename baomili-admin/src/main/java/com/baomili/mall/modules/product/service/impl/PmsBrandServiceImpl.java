package com.baomili.mall.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.order.model.OmsCartItem;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.mapper.PmsBrandMapper;
import com.baomili.mall.modules.product.service.PmsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.product.vo.PmsBrandVo;
import javafx.scene.control.Alert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public int addPmsBrand(PmsBrandDto brandDto) {
        log.info("addPmsBrand 新增商品品牌 入参：{}", brandDto);
        if (StringUtils.isBlank(brandDto.getName())) {
            throw new RuntimeException("品牌名称不能为空");
        }
        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", brandDto.getName());
        PmsBrand brand = pmsBrandMapper.selectOne(queryWrapper);
        if (Optional.ofNullable(brand).isPresent()) {
            throw new RuntimeException("商品品牌已存在");
        }
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(brandDto, pmsBrand);
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int updatePmsBrand(PmsBrandDto brandDto) {
        log.info("addPmsBrand 修改商品品牌 入参：{}", brandDto);
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(brandDto, pmsBrand);
        UpdateWrapper<PmsBrand> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", brandDto.getId());
        return pmsBrandMapper.update(pmsBrand, updateWrapper);
    }

    @Override
    public PageVo<PmsBrand> getPmsBrandPage(BrandQueryParam queryParam) {
        log.info("getPmsBrandPage 分页查询商品品牌列表 入参：{}", queryParam);
        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delete_status", 0);
        if (StringUtils.isNotBlank(queryParam.getName())) {
            queryWrapper.likeRight("name", queryParam.getName());
        }
        List<PmsBrand> brandList = pmsBrandMapper.selectList(queryWrapper);
        log.info("getPmsBrandPage 分页查询商品品牌列表 total：{}", brandList.size());
        return new PageVo<>(queryParam.getCurrent(), queryParam.getPageSize(), brandList.size(), brandList);
    }

    @Override
    public PmsBrandVo getBrandVoById(Long id) {
        log.info("getBrandVoById 查询商品品牌信息 入参：{}", id);
        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        PmsBrand pmsBrand = pmsBrandMapper.selectOne(queryWrapper);
        log.info("getBrandVoById 查询商品品牌信息：{}", pmsBrand);
        PmsBrandVo pmsBrandVo = new PmsBrandVo();
        BeanUtils.copyProperties(pmsBrand, pmsBrandVo);
        return pmsBrandVo;
    }
}
