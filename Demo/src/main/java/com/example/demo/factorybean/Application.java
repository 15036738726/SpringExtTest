package com.example.demo.factorybean;

import com.example.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将 UserFactoryBean 注册到容器中
        applicationContext.register(UserFactoryBean.class);
        applicationContext.refresh();

        System.out.println("获取到的Bean为" + applicationContext.getBean(User.class));
    }

}