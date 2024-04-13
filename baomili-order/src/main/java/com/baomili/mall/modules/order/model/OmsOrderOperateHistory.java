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
 * 订单操作历史记录
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_operate_history")
@ApiModel(value="OmsOrderOperateHistory对象", description="订单操作历史记录")
public class OmsOrderOperateHistory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer orderStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "操作人：用户；系统；后台管理员")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
