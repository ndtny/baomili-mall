package com.baomili.mall.modules.promotion.model;

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
 * 优惠券表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_coupon")
@ApiModel(value="SmsCoupon对象", description="优惠券表")
public class SmsCoupon implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "优惠码")
    private String code;

    @ApiModelProperty(value = "优惠券名称")
    private String name;

    @ApiModelProperty(value = "数量")
    private Integer count;

    @ApiModelProperty(value = "发行数量")
    private Integer publishCount;

    @ApiModelProperty(value = "每人限领张数")
    private Integer perLimit;

    @ApiModelProperty(value = "领取数量")
    private Integer receiveCount;

    @ApiModelProperty(value = "已使用数量")
    private Integer useCount;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "商品多少价格可用")
    private BigDecimal minPoint;

    @ApiModelProperty(value = "可以领取的日期")
    private Date enableReceiveTime;

    @ApiModelProperty(value = "可领取的最低会员级别")
    private Integer memberLevel;

    @ApiModelProperty(value = "有效期开始时间")
    private Date startTime;

    @ApiModelProperty(value = "有效期结束时间")
    private Date endTime;

    @ApiModelProperty(value = "使用类型：0->全场通用；1->指定分类；2->指定商品")
    private Integer useType;

    @ApiModelProperty(value = "优惠券类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券")
    private Integer type;

    @ApiModelProperty(value = "使用平台：0->全部；1->移动；2->PC")
    private Integer platform;

    @ApiModelProperty(value = "备注")
    private String remark;

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
