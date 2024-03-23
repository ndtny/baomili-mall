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
 * 秒杀活动通知记录
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_kill_promotion_notice_log")
@ApiModel(value="SmsKillPromotionNoticeLog对象", description="秒杀活动通知记录")
public class SmsKillPromotionNoticeLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "会员id")
    private Integer memberId;

    @ApiModelProperty(value = "会员电话")
    private String memberPhone;

    @ApiModelProperty(value = "会员订阅秒杀活动时间")
    private Date subscribeTime;

    @ApiModelProperty(value = "通知会员时间")
    private Date noticeTime;


}
