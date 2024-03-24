package com.baomili.mall.modules.product.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Optional;

public class ProductAttributeConstant {

    @AllArgsConstructor
    @Getter
    public enum SelectTypeEnum {

        SOLE(0, "唯一"),
        SINGLE(1, "单选"),
        MULTIPLE(2, "多选");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (SelectTypeEnum selectTypeEnum : SelectTypeEnum.values()) {
                    if(selectTypeEnum.value.equals(value)) {
                        return selectTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum InputTypeEnum {

        HAND_WORK(0, "手工录入"),
        LIST_FETCH(1, "列表获取");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (InputTypeEnum inputTypeEnum : InputTypeEnum.values()) {
                    if(inputTypeEnum.value.equals(value)) {
                        return inputTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum FilterTypeEnum {

        NORMAL(0, "普通"),
        COLOR(1, "颜色");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (FilterTypeEnum filterTypeEnum : FilterTypeEnum.values()) {
                    if(filterTypeEnum.value.equals(value)) {
                        return filterTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum SearchTypeEnum {

        UN_NEED(0, "不需要检索"),
        KEYWORD(1, "关键字检索"),
        RANGE(2, "范围检索");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (SearchTypeEnum searchTypeEnum : SearchTypeEnum.values()) {
                    if(searchTypeEnum.value.equals(value)) {
                        return searchTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum AttributeTypeEnum {

        SPECIFICATION(0, "规格"),
        PARAM(1, "参数");

        private final Integer value;
        private final String name;

        public static String getNameByValue(Integer value) {
            if (Optional.ofNullable(value).isPresent()) {
                for (AttributeTypeEnum attributeTypeEnum : AttributeTypeEnum.values()) {
                    if(attributeTypeEnum.value.equals(value)) {
                        return attributeTypeEnum.getName();
                    }
                }
            }
            return null;
        }
    }
}
