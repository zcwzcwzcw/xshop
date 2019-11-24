package com.xshop.entity;

import com.xshop.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用异常
 *
 * @author zcw
 * @date 2019/11/23
 */
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException implements Serializable {
    /** 状态码 */
    private Integer code;
    /** 错误消息 */
    private String msg;


    public BusinessException(String msg) {
        super(msg);
        this.code = StatusCode.ERROR.getCode();
        this.msg = msg;
    }

    public BusinessException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }
}
