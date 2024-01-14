package com.baomili.mall.modules.admin.constant;

import lombok.Getter;

public class UserAuthConstant {
    @Getter
    public enum IdentityType {
        PASSWORD("password", "账号密码登录"),
        PHONE_NUMBER_CAPTCHA("phoneCaptcha", "手机号验证码登录"),
        WECHAT("weChat", "微信登录"),
        QQ("QQ", "QQ登录"),
        ALIPAY("alipay", "支付宝登录"),
        WEIBO("weiBo", "微博登录"),
        APPLET_WECHAT("appletWeChat", "小程序微信登录");

        private final String value;
        private final String name;

        IdentityType(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String getNameByValue(String value) {
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
