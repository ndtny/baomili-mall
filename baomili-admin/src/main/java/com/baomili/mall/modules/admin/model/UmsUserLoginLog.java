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
 * 用户登录日志表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ums_user_login_log")
@ApiModel(value="UmsUserLoginLog对象", description="用户登录日志表")
public class UmsUserLoginLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "登录IP")
    private String ip;

    @ApiModelProperty(value = "登陆地址")
    private String address;

    @ApiModelProperty(value = "登录方式：0：PC，1：APP")
    private Integer type;

    @ApiModelProperty(value = "登陆时间")
    private Date createTime;


}
