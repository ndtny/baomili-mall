package com.baomili.mall.modules.order.model;

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
 * 订单购物车表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_cart_item")
@ApiModel(value="OmsCartItem对象", description="订单购物车表")
public class OmsCartItem implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "会员昵称")
    private String memberName;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "商品编码")
    private String productNumber;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "促销活动id")
    private Long promotionId;

    @ApiModelProperty(value = "活动信息")
    private String promotionName;

    @ApiModelProperty(value = "促销活动抵扣金额")
    private BigDecimal promotionAmount;

    @ApiModelProperty(value = "积分优惠金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "该商品经过优惠后的金额")
    private BigDecimal realAmount;

    @ApiModelProperty(value = "购买数量")
    private Integer quantity;

    @ApiModelProperty(value = "添加到购物车的价格")
    private BigDecimal price;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String modifiedBy;

    @ApiModelProperty(value = "更新时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "是否删除：0：否，1：是")
    private Boolean deleteStatus;


}
