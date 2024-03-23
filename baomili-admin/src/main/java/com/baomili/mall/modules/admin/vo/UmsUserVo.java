package com.baomili.mall.modules.admin.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@ApiModel(value="UmsUserVo对象", description="用户表")
public class UmsUserVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Boolean status;

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
