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
 * 商品信息
 * </p>
 *
 * @author David
 * @since 2024-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product")
@ApiModel(value="PmsProduct对象", description="商品信息")
public class PmsProduct implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品编码")
    private String productNumber;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "副标题")
    private String productSubTitle;

    @ApiModelProperty(value = "商品主图")
    private String masterPic;

    @ApiModelProperty(value = "商品品牌id")
    private Long brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "商品分类id")
    private Long productCategoryId;

    @ApiModelProperty(value = "商品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "运费模板id")
    private Long freightTemplateId;

    @ApiModelProperty(value = "商品属性分类id")
    private Long productAttributeCategoryId;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "商品重量，默认为克")
    private BigDecimal weight;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "赠送的成长值")
    private Integer giftGrowth;

    @ApiModelProperty(value = "赠送的积分")
    private Integer giftPoint;

    @ApiModelProperty(value = "限制使用的积分数")
    private Integer usePointLimit;

    @ApiModelProperty(value = "活动限购数量")
    private Integer promotionBuyLimit;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String productServices;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "商品详情页标题")
    private String detailTitle;

    @ApiModelProperty(value = "商品详情页内容")
    private String detailDescription;

    @ApiModelProperty(value = "促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购")
    private Integer promotionType;

    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过")
    private Integer auditStatus;

    @ApiModelProperty(value = "上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @ApiModelProperty(value = "是否为预告商品：0->不是；1->是")
    private Boolean previewStatus;

    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

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

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;


}
