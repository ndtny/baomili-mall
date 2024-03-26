package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.PmsProductDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.*;
import com.baomili.mall.modules.product.mapper.PmsProductMapper;
import com.baomili.mall.modules.product.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.product.vo.PmsProductVo;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
@DS("pms")
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Resource
    private PmsProductMapper pmsProductMapper;

    @Resource
    private PmsStockService pmsStockService;

    @Resource
    private PmsProductFullReductionService pmsProductFullReductionService;

    @Resource
    private PmsProductLadderService pmsProductLadderService;

    @Resource
    private PmsProductPromotionService pmsProductPromotionService;

    @Resource
    private PmsMemberPriceService pmsMemberPriceService;

    @Override
    @Transactional
    public int addProduct(PmsProductDto pmsProductDto) {
        log.info("addProduct 新增商品 入参：{}", pmsProductDto);
        if (StringUtils.isBlank(pmsProductDto.getProductNumber())) {
            throw new RuntimeException("商品编码不能为空");
        }
        if (StringUtils.isBlank(pmsProductDto.getProductName())) {
            throw new RuntimeException("商品名称不能为空");
        }

        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_number", pmsProductDto.getProductNumber());
        PmsProduct product = pmsProductMapper.selectOne(queryWrapper);
        if (Optional.ofNullable(product).isPresent()) {
            throw new RuntimeException("商品已存在");
        }

        PmsProduct pmsProduct = new PmsProduct();
        BeanUtils.copyProperties(pmsProductDto, pmsProduct);
        int count = pmsProductMapper.insert(pmsProduct);
        log.info("addProduct 新增商品 成功");

        PmsStock pmsStock = new PmsStock();
        pmsStock.setProductId(pmsProduct.getId());
        pmsStock.setProductNumber(pmsProduct.getProductNumber());
        pmsStock.setStock(pmsProduct.getStock());
        pmsStock.setStockWarning(pmsProductDto.getStockWarning());
        pmsStock.setCreateBy(pmsProduct.getCreateBy());
        pmsStock.setModifiedBy(pmsProduct.getModifiedBy());
        pmsStockService.save(pmsStock);
        log.info("addProduct 新增商品 保存库存成功");

        PmsProductFullReduction pmsProductFullReduction = new PmsProductFullReduction();
        pmsProductFullReduction.setProductId(pmsProduct.getId());
        pmsProductFullReduction.setFullPrice(pmsProductDto.getFullPrice());
        pmsProductFullReduction.setReducePrice(pmsProductDto.getReducePrice());
        pmsProductFullReduction.setCreateBy(pmsProduct.getCreateBy());
        pmsProductFullReduction.setModifiedBy(pmsProduct.getModifiedBy());
        pmsProductFullReductionService.save(pmsProductFullReduction);
        log.info("addProduct 新增商品 保存满减活动成功");

        PmsProductLadder pmsProductLadder = new PmsProductLadder();
        pmsProductLadder.setProductId(pmsProduct.getId());
        pmsProductLadder.setCount(pmsProductDto.getCount());
        pmsProductLadder.setDiscount(pmsProductDto.getDiscount());
        pmsProductLadder.setPrice(pmsProductDto.getDiscountPrice());
        pmsProductLadder.setCreateBy(pmsProduct.getCreateBy());
        pmsProductLadder.setModifiedBy(pmsProduct.getModifiedBy());
        pmsProductLadderService.save(pmsProductLadder);
        log.info("addProduct 新增商品 保存阶梯价格成功");

        PmsProductPromotion pmsProductPromotion = new PmsProductPromotion();
        pmsProductPromotion.setProductId(pmsProduct.getId());
        pmsProductPromotion.setPromotionPrice(pmsProductDto.getPromotionPrice());
        pmsProductPromotion.setPromotionStartTime(pmsProductDto.getPromotionStartTime());
        pmsProductPromotion.setPromotionEndTime(pmsProductDto.getPromotionEndTime());
        pmsProductPromotion.setCreateBy(pmsProduct.getCreateBy());
        pmsProductPromotion.setModifiedBy(pmsProduct.getModifiedBy());
        pmsProductPromotionService.save(pmsProductPromotion);
        log.info("addProduct 新增商品 保存促销价格成功");

        PmsMemberPrice pmsMemberPrice = new PmsMemberPrice();
        pmsMemberPrice.setProductId(pmsProduct.getId());
        pmsMemberPrice.setMemberPrice(pmsProductDto.getMemberPrice());
        pmsMemberPrice.setMemberLevelId(pmsProductDto.getMemberLevelId());
        pmsMemberPrice.setMemberLevelName(pmsProductDto.getMemberLevelName());
        pmsMemberPrice.setCreateBy(pmsProduct.getCreateBy());
        pmsMemberPrice.setModifiedBy(pmsProduct.getModifiedBy());
        pmsMemberPriceService.save(pmsMemberPrice);
        log.info("addProduct 新增商品 保存会员价格成功");
        return count;
    }

    @Override
    public int updateProduct(PmsProductDto pmsProductDto) {
        return 0;
    }

    @Override
    public PageVo<PmsProduct> getProductPage(ProductQueryParam param) {
        log.info("getProductPage 分页查询商品 入参：{}", param);
        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delete_status", 0);
        if (StringUtils.isNotBlank(param.getProductNumber())) {
            queryWrapper.likeRight("product_number", param.getProductNumber());
        }
        if (StringUtils.isNotBlank(param.getProductName())) {
            queryWrapper.likeRight("product_name", param.getProductName());
        }
        List<PmsProduct> list = pmsProductMapper.selectList(queryWrapper);
        return new PageVo<>(param.getCurrent(), param.getPageSize(), list.size(), list);
    }

    @Override
    public PmsProductVo getProductById(Long id) {
        log.info("getProductById 查询商品 入参：{}", id);
        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        PmsProduct pmsProduct = pmsProductMapper.selectOne(queryWrapper);
        PmsProductVo pmsProductVo = new PmsProductVo();
        BeanUtils.copyProperties(pmsProduct, pmsProductVo);
        log.info("getProductById 查询商品 商品信息");

        QueryWrapper<PmsStock> stockQueryWrapper = new QueryWrapper<>();
        stockQueryWrapper.eq("product_id", id);
        PmsStock pmsStock = pmsStockService.getOne(stockQueryWrapper);
        pmsProductVo.setStock(pmsStock.getStock());
        pmsProductVo.setStockWarning(pmsProductVo.getStockWarning());
        log.info("getProductById 查询商品 商品库存信息");

        QueryWrapper<PmsProductFullReduction> fullReductionQueryWrapper = new QueryWrapper<>();
        fullReductionQueryWrapper.eq("product_id", id);
        PmsProductFullReduction pmsProductFullReduction = pmsProductFullReductionService.getOne(fullReductionQueryWrapper);
        pmsProductVo.setFullPrice(pmsProductFullReduction.getFullPrice());
        pmsProductVo.setReducePrice(pmsProductFullReduction.getReducePrice());
        log.info("getProductById 查询商品 商品满减价格信息");

        QueryWrapper<PmsProductLadder> productLadderQueryWrapper = new QueryWrapper<>();
        productLadderQueryWrapper.eq("product_id", id);
        PmsProductLadder pmsProductLadder = pmsProductLadderService.getOne(productLadderQueryWrapper);
        pmsProductVo.setCount(pmsProductLadder.getCount());
        pmsProductVo.setDiscount(pmsProductLadder.getDiscount());
        pmsProductVo.setDiscountPrice(pmsProductLadder.getPrice());
        log.info("getProductById 查询商品 商品阶梯价格信息");

        QueryWrapper<PmsProductPromotion> productPromotionQueryWrapper = new QueryWrapper<>();
        productPromotionQueryWrapper.eq("product_id", id);
        PmsProductPromotion pmsProductPromotion = pmsProductPromotionService.getOne(productPromotionQueryWrapper);
        pmsProductVo.setPromotionPrice(pmsProductPromotion.getPromotionPrice());
        pmsProductVo.setPromotionStartTime(pmsProductPromotion.getPromotionStartTime());
        pmsProductVo.setPromotionEndTime(pmsProductPromotion.getPromotionEndTime());
        log.info("getProductById 查询商品 商品促销价格信息");

        QueryWrapper<PmsMemberPrice> pmsMemberPriceQueryWrapper = new QueryWrapper<>();
        pmsMemberPriceQueryWrapper.eq("product_id", id);
        PmsMemberPrice pmsMemberPrice = pmsMemberPriceService.getOne(pmsMemberPriceQueryWrapper);
        pmsProductVo.setMemberPrice(pmsMemberPrice.getMemberPrice());
        pmsProductVo.setMemberLevelId(pmsMemberPrice.getMemberLevelId());
        pmsProductVo.setMemberLevelName(pmsMemberPrice.getMemberLevelName());
        log.info("getProductById 查询商品 商品会员价格信息");

        log.info("getProductById 查询商品 商品全部信息：{}", pmsProductVo);
        return pmsProductVo;
    }
}
