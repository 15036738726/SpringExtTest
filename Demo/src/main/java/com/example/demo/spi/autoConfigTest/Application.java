package com.example.demo.spi.autoConfigTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        // 获取通过自动加载 创建出的bean对象
        UserAutoConfiguration bean = run.getBean(UserAutoConfiguration.class);
        System.out.println("获取到的Bean为" + bean);
    }
}
