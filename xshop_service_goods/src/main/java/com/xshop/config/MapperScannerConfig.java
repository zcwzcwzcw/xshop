package com.xshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * mybatis mapper扫描配置类
 *
 * @author zcw
 * @date 2019/11/20
 */
@Configuration
public class MapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.xshop.dao");
        return configurer;
    }
}
