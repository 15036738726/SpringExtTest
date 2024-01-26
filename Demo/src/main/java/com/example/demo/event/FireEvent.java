package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 定义事件
 */
public class FireEvent extends ApplicationEvent {
    public FireEvent(Object source) {
        super(source);
        System.out.println(source);
    }

    public FireEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
