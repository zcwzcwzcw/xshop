package com.xshop.controller;

import com.xshop.entity.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * @author zcw
 * @date 2019/11/11
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResponse handler(Exception e) {
        return CommonResponse.error(e.getMessage());
    }
}
