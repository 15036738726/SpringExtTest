package com.example.demo.event;

import org.springframework.context.ApplicationListener;

/**
 * 打119事件  传入监听的对象
 */
public class Call119FireEventListener implements ApplicationListener<FireEvent> {
    @Override
    public void onApplicationEvent(FireEvent event) {
        System.out.println("打119");
    }
}
