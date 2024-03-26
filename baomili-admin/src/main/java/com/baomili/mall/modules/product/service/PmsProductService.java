package com.baomili.mall.modules.product.service;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.PmsProductDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.product.vo.PmsProductVo;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface PmsProductService extends IService<PmsProduct> {

    int addProduct(PmsProductDto pmsProductDto);

    int updateProduct(PmsProductDto pmsProductDto);

    PageVo<PmsProduct> getProductPage(ProductQueryParam param);

    PmsProductVo getProductById(Long id);
}
