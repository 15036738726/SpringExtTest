package com.example.demo.BeanPostProcessor;

import com.example.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(UserBeanPostProcessor.class);
        applicationContext.register(User.class);
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        System.out.println("获取到的Bean为" + user + "，属性username值为：" + user.getUsername());
    }
}
