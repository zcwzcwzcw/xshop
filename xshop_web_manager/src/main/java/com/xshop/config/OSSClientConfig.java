package com.xshop.config;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OOSClient配置类
 *
 * @author zcw
 * @date 2019/11/20
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss")
public class OSSClientConfig {
    private String endpoint;
    private String accessKeyId;
    private String secretAccessKey;

    @Bean
    public OSSClient ossClient() {
        return new OSSClient(endpoint, accessKeyId, secretAccessKey);
    }
}
