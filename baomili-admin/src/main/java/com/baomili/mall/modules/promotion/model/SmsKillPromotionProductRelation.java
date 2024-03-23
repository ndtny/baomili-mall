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
 * 秒杀活动与商品关系表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_kill_promotion_product_relation")
@ApiModel(value="SmsKillPromotionProductRelation对象", description="秒杀活动与商品关系表")
public class SmsKillPromotionProductRelation implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "秒杀id")
    private Long killPromotionId;

    @ApiModelProperty(value = "秒杀场次id")
    private Long killPromotionSessionId;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "秒杀价格")
    private BigDecimal killPromotionPrice;

    @ApiModelProperty(value = "秒杀数量")
    private Integer killPromotionCount;

    @ApiModelProperty(value = "每人限购数量")
    private Integer killPromotionLimit;

    @ApiModelProperty(value = "排序")
    private Integer sort;

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
