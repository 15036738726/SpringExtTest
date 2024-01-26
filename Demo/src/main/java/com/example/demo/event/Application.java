package com.example.demo.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Call119FireEventListener.class);
        applicationContext.register(HelpPersonFireEventListener.class);
        applicationContext.refresh();
        applicationContext.publishEvent(new FireEvent("着火了"));;
        // 可以通过ApplicationContextAware 拿到applicationContext对象  然后注册监听事件
    }
}
