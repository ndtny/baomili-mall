package com.baomili.mall.modules.product.dto;

import com.baomili.mall.modules.common.dto.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BrandQueryParam extends PageQueryParam {
    private static final long serialVersionUID = -7709590539693951878L;

    @ApiModelProperty(value = "品牌名字")
    private String name;
}
