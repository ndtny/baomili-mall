package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsProductFullReduction;
import com.baomili.mall.modules.product.mapper.PmsProductFullReductionMapper;
import com.baomili.mall.modules.product.service.PmsProductFullReductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品满减活动表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
@DS("pms")
public class PmsProductFullReductionServiceImpl extends ServiceImpl<PmsProductFullReductionMapper, PmsProductFullReduction> implements PmsProductFullReductionService {

}
