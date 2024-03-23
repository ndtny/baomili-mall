package com.baomili.mall.modules.product.model;

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
 * 商品分类表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_category")
@ApiModel(value="PmsProductCategory对象", description="商品分类表")
public class PmsProductCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父级id：0表示一级分类")
    private Long parentId;

    @ApiModelProperty(value = "商品分类名称")
    private String name;

    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Boolean showBarStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Boolean showStatus;

    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "描述")
    private String description;

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
