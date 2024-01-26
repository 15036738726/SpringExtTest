package com.example.demo.xsd;

import com.example.demo.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);

        System.out.println(user);
    }
}
