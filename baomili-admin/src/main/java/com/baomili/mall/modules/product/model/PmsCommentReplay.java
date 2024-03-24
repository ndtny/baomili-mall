package com.baomili.mall.modules.product.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品评论回复表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_comment_replay")
@ApiModel(value="PmsCommentReplay对象", description="商品评论回复表")
public class PmsCommentReplay implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "评论id")
    private Long commentId;

    @ApiModelProperty(value = "回复评论用户名称")
    private String memberName;

    @ApiModelProperty(value = "回复评论用户头像")
    private String memberAvatar;

    @ApiModelProperty(value = "回复评论内容")
    private String content;

    @ApiModelProperty(value = "评论人员类型；0->会员；1->管理员")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "是否删除：0：否，1：是")
    private Boolean deleteStatus;


}
