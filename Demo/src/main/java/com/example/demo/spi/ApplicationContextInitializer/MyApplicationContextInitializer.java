package com.example.demo.spi.ApplicationContextInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
// spring.factories中配置 项目启动时会进入这个方法
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("xxxxx");
    }
}
