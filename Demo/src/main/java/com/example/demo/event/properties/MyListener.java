package com.example.demo.event.properties;

import com.example.demo.event.anno.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
// 在配置文件中配置监听,把监听对象注入到容器中  context.listener.classes = com.example.demo.event.properties.MyListener
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        // 监听逻辑
        System.out.println("监听到了事件");
    }
}
