package com.baomili.mall.modules.admin.model;

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
 * 用户授权信息表
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ums_user_auth")
@ApiModel(value="UmsUserAuth对象", description="用户授权信息表")
public class UmsUserAuth implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "登录类型（密码、手机号、邮箱、第三方登录）")
    private Integer identityType;

    @ApiModelProperty(value = "账号、手机号、邮箱、第三方唯一标识")
    private String identityId;

    @ApiModelProperty(value = "密码凭证（账号密码、第三方token）")
    private String credential;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;


}
