package com.baomili.mall.modules.common.constant;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "没有找到资源"),
    UNAUTHORIZED(401, "没有操作权限"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOWN(500, "未知异常，请稍后再试！");

    private final Integer code;

    private final String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
