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
 * 用户授权信息表
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@Data
@ApiModel(value="UmsUserAuthVo对象")
public class UmsUserAuthVo implements Serializable {

    private static final long serialVersionUID = -187904384445472956L;

    @ApiModelProperty(value = "主键id")
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
