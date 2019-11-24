package com.xshop.advice;

import com.alibaba.dubbo.rpc.RpcException;
import com.xshop.entity.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * dubbo provider自定义异常BusinessException转换
 * {@link BusinessException}
 *
 * @author zcw
 * @date 2019/11/23
 */
@Slf4j
@Aspect
@Component
public class ExceptionAdvice {
    @AfterThrowing(throwing = "e", pointcut = "execution(* com.xshop.service.impl.*.*(..))")
    public void afterThrowing(Throwable e) {
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            throw new RpcException(be.getCode(), be.getMsg(), e);
        }
    }
}
