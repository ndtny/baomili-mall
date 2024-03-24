package com.baomili.mall.modules.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.product.vo.PmsBrandVo;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface PmsBrandService extends IService<PmsBrand> {

    int addPmsBrand(PmsBrandDto brandDto);

    int updatePmsBrand(PmsBrandDto brandDto);

    PageVo<PmsBrand> getPmsBrandPage(BrandQueryParam queryParam);

    PmsBrandVo getBrandVoById(Long id);
}
