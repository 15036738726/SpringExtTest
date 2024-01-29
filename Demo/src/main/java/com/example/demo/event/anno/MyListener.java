package com.example.demo.event.anno;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
    @EventListener(MyEvent.class)
    public void t1(MyEvent event){
        // 监听逻辑
        System.out.println("监听到了事件");
    }
}
