package com.example.demo.event;

import org.springframework.context.ApplicationListener;

/**
 * 救人事件 传入监听的事件
 */
public class HelpPersonFireEventListener implements ApplicationListener<FireEvent> {
    @Override
    public void onApplicationEvent(FireEvent event) {
        System.out.println("救人");
    }
}
