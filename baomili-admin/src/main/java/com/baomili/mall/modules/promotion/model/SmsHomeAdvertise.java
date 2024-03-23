package com.baomili.mall.modules.promotion.model;

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
 * 首页轮播广告表
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_home_advertise")
@ApiModel(value="SmsHomeAdvertise对象", description="首页轮播广告表")
public class SmsHomeAdvertise implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "广告名称")
    private String name;

    @ApiModelProperty(value = "轮播位置：0->PC首页轮播；1->app首页轮播")
    private Integer type;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "状态：0->下线；1->上线")
    private Integer status;

    @ApiModelProperty(value = "点击数")
    private Integer clickCount;

    @ApiModelProperty(value = "下单数")
    private Integer orderCount;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "备注")
    private String remark;

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
