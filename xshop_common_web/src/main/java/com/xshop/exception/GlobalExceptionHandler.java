package com.xshop.exception;

import com.alibaba.dubbo.rpc.RpcException;
import com.xshop.entity.BusinessException;
import com.xshop.entity.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author zcw
 * @date 2019/11/11
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResponse handler(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return CommonResponse.error(be.getCode(), be.getMsg());
        } else if (e instanceof RpcException) {
            RpcException re = (RpcException) e;
            return CommonResponse.error(re.getCode(), re.getMessage());
        }
        return CommonResponse.error(e.getMessage());
    }
}
