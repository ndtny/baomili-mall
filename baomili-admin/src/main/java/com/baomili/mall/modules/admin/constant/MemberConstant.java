package com.baomili.mall.modules.admin.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

public class MemberConstant {

    @AllArgsConstructor
    @Getter
    public enum MemberTypeEnum {
        NORMAL(0L, "普通用户"),
        SILVER(1L, "白银会员"),
        GOLD(2L, "黄金会员"),
        PLATINUM(3L, "白金会员"),
        DIAMONDS(4L, "钻石会员");

        private final Long value;
        private final String name;

        public static String getNameByValue(Long value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (MemberTypeEnum memberTypeEnum : MemberTypeEnum.values()) {
                    if(memberTypeEnum.value.equals(value)) {
                        return memberTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }
}
