package com.baomili.mall.modules.product.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.product.model.PmsMemberPrice;
import com.baomili.mall.modules.product.mapper.PmsMemberPriceMapper;
import com.baomili.mall.modules.product.service.PmsMemberPriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品会员价格表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
@DS("pms")
public class PmsMemberPriceServiceImpl extends ServiceImpl<PmsMemberPriceMapper, PmsMemberPrice> implements PmsMemberPriceService {

}
