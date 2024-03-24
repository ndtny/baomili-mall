package com.baomili.mall.modules.product.dto;

import com.baomili.mall.modules.common.dto.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductCategoryQueryParam extends PageQueryParam {


    private static final long serialVersionUID = 261379886209815697L;

    @ApiModelProperty(value = "分类名称")
    private String name;
}
