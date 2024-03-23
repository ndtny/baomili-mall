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
 * 商品评论表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_comment")
@ApiModel(value="PmsComment对象", description="商品评论表")
public class PmsComment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "评论用户名称")
    private String memberName;

    @ApiModelProperty(value = "评论用户头像")
    private String memberAvatar;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "评价星数：0->5")
    private Integer commentStar;

    @ApiModelProperty(value = "评价的ip")
    private String memberIp;

    @ApiModelProperty(value = "是否展示：1：展示，0：不展示")
    private Boolean showStatus;

    @ApiModelProperty(value = "购买时的商品属性")
    private String productAttribute;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "上传图片地址，以逗号隔开")
    private String pics;

    @ApiModelProperty(value = "评论时间")
    private Date createTime;

    @ApiModelProperty(value = "是否删除：0：否，1：是")
    private Boolean deleteStatus;


}
