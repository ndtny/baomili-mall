package com.baomili.mall.modules.product.dto;

import com.baomili.mall.modules.common.dto.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttributeQueryParam extends PageQueryParam {

    private static final long serialVersionUID = -4856762351641370997L;

    @ApiModelProperty(value = "属性名称")
    private String attributeName;
}
