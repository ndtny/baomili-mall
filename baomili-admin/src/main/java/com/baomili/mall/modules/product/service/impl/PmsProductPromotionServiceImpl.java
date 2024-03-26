package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsProductPromotion;
import com.baomili.mall.modules.product.mapper.PmsProductPromotionMapper;
import com.baomili.mall.modules.product.service.PmsProductPromotionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品促销活动表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-26
 */
@Service
@Slf4j
@DS("pms")
public class PmsProductPromotionServiceImpl extends ServiceImpl<PmsProductPromotionMapper, PmsProductPromotion> implements PmsProductPromotionService {

}
