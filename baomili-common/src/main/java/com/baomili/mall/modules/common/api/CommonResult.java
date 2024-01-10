package com.baomili.mall.modules.common.api;

import com.baomili.mall.modules.common.constant.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 8676831655828746126L;

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message);
    }

    public static <T> CommonResult<T> failed(Integer code, String message) {
        return new CommonResult<T>(code, message);
    }
}
