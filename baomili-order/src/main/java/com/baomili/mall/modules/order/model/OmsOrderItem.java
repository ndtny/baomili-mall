package com.baomili.mall.modules.order.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单商品明细
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_item")
@ApiModel(value="OmsOrderItem对象", description="订单商品明细")
public class OmsOrderItem implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品编码")
    private String productNumber;

    @ApiModelProperty(value = "优惠券id")
    private Long couponId;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "优惠券抵扣金额")
    private BigDecimal couponAmount;

    @ApiModelProperty(value = "阶梯优惠活动id")
    private Long ladderId;

    @ApiModelProperty(value = "阶梯优惠活动名称")
    private String ladderName;

    @ApiModelProperty(value = "阶梯优惠活动抵扣金额")
    private BigDecimal ladderAmount;

    @ApiModelProperty(value = "满减活动id")
    private Long fullReductionId;

    @ApiModelProperty(value = "满减活动名称")
    private String fullReductionName;

    @ApiModelProperty(value = "满减活动抵扣金额")
    private BigDecimal fullReductionAmount;

    @ApiModelProperty(value = "积分优惠金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "该商品经过优惠后的金额")
    private BigDecimal realAmount;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal price;

    @ApiModelProperty(value = "购买数量")
    private Integer quantity;

    @ApiModelProperty(value = "赠送积分")
    private Integer giftIntegration;

    @ApiModelProperty(value = "赠送成长值")
    private Integer giftGrowth;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String modifiedBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;


}
