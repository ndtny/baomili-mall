package com.baomili.mall.modules.product.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

public class ProductConstant {

    @AllArgsConstructor
    @Getter
    public enum ServiceTypeEnum {

        FREE_RETURNS(1, "无忧退货"),
        QUICK_REFUND(2, "快速退款"),
        FREE_SHIPPING(3, "免费包邮");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (ServiceTypeEnum serviceTypeEnum : ServiceTypeEnum.values()) {
                    if(serviceTypeEnum.value.equals(value)) {
                        return serviceTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum PromotionTypeEnum {

        ORIGINAL_PRICE(0, "原价"),
        PROMOTION_PRICE(1, "促销价格"),
        MEMBER_PRICE(2, "会员价格"),
        LADDER_PRICE(3, "阶梯价格"),
        FULL_REDUCE_PRICE(4, "满减价格"),
        KILL(5, "秒杀");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (PromotionTypeEnum promotionTypeEnum : PromotionTypeEnum.values()) {
                    if(promotionTypeEnum.value.equals(value)) {
                        return promotionTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }
}
