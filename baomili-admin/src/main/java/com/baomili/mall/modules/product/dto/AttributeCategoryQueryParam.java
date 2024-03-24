package com.baomili.mall.modules.product.dto;

import com.baomili.mall.modules.common.dto.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttributeCategoryQueryParam extends PageQueryParam {

    private static final long serialVersionUID = 7202456153905091125L;

    @ApiModelProperty(value = "属性分类名称")
    private String name;
}
