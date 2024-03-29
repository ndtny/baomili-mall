package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsStock;
import com.baomili.mall.modules.product.mapper.PmsStockMapper;
import com.baomili.mall.modules.product.service.PmsStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品库存 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
@DS("pms")
public class PmsStockServiceImpl extends ServiceImpl<PmsStockMapper, PmsStock> implements PmsStockService {

}
