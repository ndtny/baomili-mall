package com.baomili.mall.modules.order.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderQueryParamDto implements Serializable {
    private static final long serialVersionUID = 188337245232642490L;

    private Long memberId;

    private Integer orderStatus;

    private String productName;

    private String productBrand;
}
