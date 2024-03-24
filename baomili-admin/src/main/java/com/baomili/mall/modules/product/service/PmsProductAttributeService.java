package com.baomili.mall.modules.product.service;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductAttributeDto;
import com.baomili.mall.modules.product.model.PmsProductAttribute;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.product.vo.PmsProductAttributeVo;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface PmsProductAttributeService extends IService<PmsProductAttribute> {

    int addAttribute(PmsProductAttributeDto pmsProductAttributeDto);

    int updateAttribute(PmsProductAttributeDto pmsProductAttributeDto);

    PmsProductAttributeVo getAttributeById(Long id);

    PageVo<PmsProductAttribute> getPmsAttributePage(AttributeQueryParam queryParam);
}
