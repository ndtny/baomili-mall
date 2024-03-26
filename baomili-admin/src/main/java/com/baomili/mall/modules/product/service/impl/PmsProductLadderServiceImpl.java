package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsProductLadder;
import com.baomili.mall.modules.product.mapper.PmsProductLadderMapper;
import com.baomili.mall.modules.product.service.PmsProductLadderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品阶梯优惠活动表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
@DS("pms")
public class PmsProductLadderServiceImpl extends ServiceImpl<PmsProductLadderMapper, PmsProductLadder> implements PmsProductLadderService {

}
