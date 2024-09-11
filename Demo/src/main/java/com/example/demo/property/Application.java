package com.example.demo.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        PropertySourceTest bean = run.getBean(PropertySourceTest.class);
        System.out.println(bean.getPort());
    }
}
