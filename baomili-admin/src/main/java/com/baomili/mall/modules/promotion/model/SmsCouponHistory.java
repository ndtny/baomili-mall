package com.baomili.mall.modules.promotion.model;

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
 * 优惠券使用、领取历史表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_coupon_history")
@ApiModel(value="SmsCouponHistory对象", description="优惠券使用、领取历史表")
public class SmsCouponHistory implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "优惠券id")
    private Long couponId;

    @ApiModelProperty(value = "优惠码")
    private String couponCode;

    @ApiModelProperty(value = "使用/领取优惠券的会员id")
    private Long memberId;

    @ApiModelProperty(value = "使用/领取人昵称")
    private String memberName;

    @ApiModelProperty(value = "获取类型：0->后台赠送；1->主动获取")
    private Integer getType;

    @ApiModelProperty(value = "使用状态：0->未使用；1->已使用；2->已过期")
    private Integer useStatus;

    @ApiModelProperty(value = "使用时间")
    private Date useTime;

    @ApiModelProperty(value = "使用的订单id")
    private Long orderId;

    @ApiModelProperty(value = "使用的订单号码")
    private String orderNumber;

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
