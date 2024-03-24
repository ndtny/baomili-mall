package com.baomili.mall.modules.product.dto;

import com.baomili.mall.modules.common.dto.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductQueryParam extends PageQueryParam {
    private static final long serialVersionUID = -7709590539693951878L;

    @ApiModelProperty(value = "商品编码")
    private String productNumber;

    @ApiModelProperty(value = "商品名称")
    private String productName;
}
