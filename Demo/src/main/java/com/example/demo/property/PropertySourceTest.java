package com.example.demo.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 读取配置文件属性测试 ConfigurationProperties
 */
@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class PropertySourceTest {
    private Integer port;
}
