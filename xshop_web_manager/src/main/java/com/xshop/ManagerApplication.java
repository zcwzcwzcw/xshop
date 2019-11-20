package com.xshop;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动类
 * @author zcw
 * @date 2019/11/19
 */
@EnableDubbo
@SpringBootApplication
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
