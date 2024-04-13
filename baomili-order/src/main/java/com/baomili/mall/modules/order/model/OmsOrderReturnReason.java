package com.baomili.mall.modules.order.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 退货原因表
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_return_reason")
@ApiModel(value="OmsOrderReturnReason对象", description="退货原因表")
public class OmsOrderReturnReason implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "退货申请id")
    private Long orderReturnApplyId;

    @ApiModelProperty(value = "退货原因")
    private String returnReason;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "凭证图片，以逗号隔开")
    private String proofPics;

    @ApiModelProperty(value = "退货类型")
    private String type;

    @ApiModelProperty(value = "状态：0->不启用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
