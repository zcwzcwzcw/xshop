package com.xshop.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码
 * @author zcw
 * @date 2019/11/11
 */
@AllArgsConstructor
@Getter
public enum StatusCode {
    // 状态信息
    SUCCESS(0, "成功"),
    ERROR(-1, "错误"),
    PARAMETER_MISSING(1, "参数缺失"),
    LOGIN_ERROR(2, "用户名或密码错误"),
    USERNAME_EXIST(3, "用户名已存在"),
    EMAIL_EXIST(4, "邮箱已存在"),
    PARAMETER_INVALID(5, "参数无效"),
    TOKEN_ERROR(6, "token错误"),
    USER_NOT_LOGIN(7, "用户未登录"),
    PASSWORD_ERROR(8, "密码错误"),
    USER_NOT_ADMIN(9, "非管理员用户，无权操作")
    ;

    /** 状态码 */
    private Integer code;
    /** 信息 */
    private String msg;
}
