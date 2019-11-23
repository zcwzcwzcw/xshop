package com.xshop.entity;

import com.xshop.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回
 * @author zcw
 * @date 2019/11/11
 */
@Data
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {
    /** 状态码，0为成功，非0表示失败 */
    private Integer code;
    /** 数据 */
    private T data;
    /** 响应信息 */
    private String msg;


    public static <T> CommonResponse<T> success(T data, String msg) {
        return new CommonResponse<T>(StatusCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, "success");
    }

    public static CommonResponse success(String msg) {
        return success(null, msg);
    }

    public static <T> CommonResponse<T> success() {
        return success(null);
    }

    public static <T> CommonResponse<T> error(Integer code, T data, String msg) {
        return new CommonResponse<T>(code, data, msg);
    }

    public static <T> CommonResponse<T> error(Integer code, String msg) {
        return error(code, null, msg);
    }

    public static <T> CommonResponse<T> error(String msg) {
        return error(StatusCode.ERROR.getCode(), msg);
    }
}