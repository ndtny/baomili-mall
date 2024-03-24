package com.baomili.mall.modules.product.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 运费模版
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_feight_template")
@ApiModel(value="PmsFeightTemplate对象", description="运费模版")
public class PmsFeightTemplate implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "模版名称")
    private String name;

    @ApiModelProperty(value = "计费类型:0->按重量；1->按件数")
    private Integer chargeType;

    @ApiModelProperty(value = "首重kg")
    private BigDecimal firstWeight;

    @ApiModelProperty(value = "首费（元）")
    private BigDecimal firstFee;

    @ApiModelProperty(value = "增重Kg")
    private BigDecimal continueWeight;

    @ApiModelProperty(value = "超出首重（元）/Kg")
    private BigDecimal continmeFee;

    @ApiModelProperty(value = "目的地（省、市）")
    private String destination;

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

    @ApiModelProperty(value = "是否删除：0：否，1：是")
    private Boolean deleteStatus;


}
