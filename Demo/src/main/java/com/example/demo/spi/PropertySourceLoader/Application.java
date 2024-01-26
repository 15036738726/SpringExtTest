package com.example.demo.spi.PropertySourceLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        User user = run.getBean(User.class);
        System.out.println("获取到的Bean为" + user + "，属性username值为：" + user.getUsername());
    }

    @Bean
    public User user(){
        return new User();
    }
}
