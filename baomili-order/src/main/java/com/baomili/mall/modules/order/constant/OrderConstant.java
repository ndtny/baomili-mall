package com.baomili.mall.modules.order.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class OrderConstant {

    @Getter
    @AllArgsConstructor
    public enum PayTypeEnum {
        UN_PAY(0,"未支付"),
        ALIPAY(1,"支付宝"),
        WECHAT(2,"微信");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (value != null) {
                for (PayTypeEnum payTypeEnum : PayTypeEnum.values()) {
                    if (value.equals(payTypeEnum.getValue())) {
                        return payTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum SourceTypeEnum {
        PC(0,"PC订单"),
        APP(1,"APP订单");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (value != null) {
                for (SourceTypeEnum sourceTypeEnum : SourceTypeEnum.values()) {
                    if (value.equals(sourceTypeEnum.getValue())) {
                        return sourceTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum OrderStatusEnum {
        PENDING_PAYMENT(0,"待付款"),
        PENDING_SEND(1,"待发货"),
        ALREADY_SEND(2,"已发货"),
        ALREADY_SIGN(3,"已签收"),
        ALREADY_REFUND(4,"已退款"),
        INVALID(5,"无效订单");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (value != null) {
                for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
                    if (value.equals(orderStatusEnum.getValue())) {
                        return orderStatusEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum OrderTypeEnum {
        NORMAL(0,"正常订单"),
        KILL(1,"秒杀订单");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (value != null) {
                for (OrderTypeEnum orderTypeEnum : OrderTypeEnum.values()) {
                    if (value.equals(orderTypeEnum.getValue())) {
                        return orderTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }
}
