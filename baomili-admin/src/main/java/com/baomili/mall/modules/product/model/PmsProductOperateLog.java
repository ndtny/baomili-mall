package com.baomili.mall.modules.product.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品操作记录表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_operate_log")
@ApiModel(value="PmsProductOperateLog对象", description="产品操作记录表")
public class PmsProductOperateLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "价格（旧）")
    private BigDecimal priceOld;

    @ApiModelProperty(value = "价格（新）")
    private BigDecimal priceNew;

    @ApiModelProperty(value = "售卖价格（旧）")
    private BigDecimal salePriceOld;

    @ApiModelProperty(value = "售卖价格（新）")
    private BigDecimal salePriceNew;

    @ApiModelProperty(value = "赠送的积分（旧）")
    private Integer giftPointOld;

    @ApiModelProperty(value = "赠送的积分（新）")
    private Integer giftPointNew;

    @ApiModelProperty(value = "限制购买数量（旧）")
    private Integer usePointLimitOld;

    @ApiModelProperty(value = "限制购买数量（新）")
    private Integer usePointLimitNew;

    @ApiModelProperty(value = "操作人")
    private String createBy;

    @ApiModelProperty(value = "操作时间")
    private Date createTime;


}
