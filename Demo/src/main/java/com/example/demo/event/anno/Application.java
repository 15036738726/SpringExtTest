package com.example.demo.event.anno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        // 事件发布
        run.publishEvent(new MyEvent("我的事件..."));
        /**
         * // https://www.cnblogs.com/javasl/p/11827842.html
         * // SpringBoot使用四种方式实现事件监听
         */
    }
}
