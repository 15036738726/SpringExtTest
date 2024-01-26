package com.example.demo.spi.autoConfigTest;
public class UserAutoConfiguration {
    // 通过在spring.factories中配置 实现自动装配当前类
    // key为org.springframework.boot.autoconfigure.EnableAutoConfiguration
    // 因为走的是spring的 SPI 他会扫描所有资源文件下的factories文件  包括当前应用+类路径中引入的jar包中的
}