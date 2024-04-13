package com.baomili.mall.modules.order.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OmsOrderDto对象", description="订单表")
public class OmsOrderDto implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单id")
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "应付金额（实际支付金额）")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "运费金额")
    private BigDecimal freightAmount;

    @ApiModelProperty(value = "促销优惠金额（促销价、满减、阶梯价）")
    private BigDecimal promotionAmount;

    @ApiModelProperty(value = "积分抵扣金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "管理员后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "下单时使用的积分")
    private Integer useIntegration;

    @ApiModelProperty(value = "支付方式：0->未支付；1->支付宝；2->微信")
    private Integer payType;

    @ApiModelProperty(value = "订单来源：0->PC订单；1->app订单")
    private Integer sourceType;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已签收；4->已退款；5->无效订单")
    private Integer status;

    @ApiModelProperty(value = "订单类型：0->正常订单；1->秒杀订单")
    private Integer orderType;

    @ApiModelProperty(value = "物流公司(配送方式)")
    private String deliveryCompany;

    @ApiModelProperty(value = "物流单号")
    private String deliveryNumber;

    @ApiModelProperty(value = "可获得的积分")
    private Integer integration;

    @ApiModelProperty(value = "可获得额活动成长值")
    private Integer growth;

    @ApiModelProperty(value = "发票类型：0->不开发票；1->电子发票；2->纸质发票")
    private Integer billType;

    @ApiModelProperty(value = "发票抬头")
    private String billHeader;

    @ApiModelProperty(value = "发票内容")
    private String billContent;

    @ApiModelProperty(value = "收票人电话")
    private String billReceiverPhone;

    @ApiModelProperty(value = "收票人邮箱")
    private String billReceiverEmail;

    @ApiModelProperty(value = "收货人姓名")
    private String receiveUser;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "省/直辖市")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String region;

    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "确认收货状态：0->未确认；1->已确认")
    private Integer confirmStatus;

    @ApiModelProperty(value = "自动确认时间（天）")
    private Integer autoConfirmDay;

    @ApiModelProperty(value = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(value = "发货时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "确认收货时间")
    private Date receiveTime;

    @ApiModelProperty(value = "评价时间")
    private Date commentTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Boolean deleteStatus;

    @ApiModelProperty(value = "订单商品明细")
    private List<OmsOrderItemDto> omsOrderItemDtoList;
}
