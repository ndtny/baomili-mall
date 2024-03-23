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
 * 订单退货申请
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_return_apply")
@ApiModel(value="OmsOrderReturnApply对象", description="订单退货申请")
public class OmsOrderReturnApply implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "订单明细id")
    private Long orderItemId;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "订单收货地址id")
    private Long orderAddressId;

    @ApiModelProperty(value = "退货商品id")
    private Long productId;

    @ApiModelProperty(value = "商品图片")
    private String productPic;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "退货数量")
    private Integer productCount;

    @ApiModelProperty(value = "商品单价")
    private BigDecimal price;

    @ApiModelProperty(value = "商品实际支付单价")
    private BigDecimal productRealPrice;

    @ApiModelProperty(value = "申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝；4->已关闭")
    private Integer status;

    @ApiModelProperty(value = "处理备注")
    private String handleRemark;

    @ApiModelProperty(value = "处理人员")
    private String handleBy;

    @ApiModelProperty(value = "处理时间")
    private Date handleTime;

    @ApiModelProperty(value = "申请时间")
    private Date createTime;


}
