package com.baomili.mall.modules.admin.constant;

import lombok.Getter;

public class UserAuthConstant {
    @Getter
    public enum IdentityType {
        PASSWORD(1, "账号密码登录"),
        PHONE_NUMBER_CAPTCHA(2, "手机号验证码登录"),
        WECHAT(3, "微信登录"),
        QQ(4, "QQ登录"),
        ALIPAY(5, "支付宝登录"),
        WEIBO(6, "微博登录"),
        APPLET_WECHAT(7, "小程序微信登录");

        private final Integer value;
        private final String name;

        IdentityType(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String getNameByValue(Integer value) {
            if (value != null) {
                for (IdentityType identityType : IdentityType.values()) {
                    if (value.equals(identityType.value)) {
                        return identityType.getName();
                    }
                }
            }
            return null;
        }
    }
}
