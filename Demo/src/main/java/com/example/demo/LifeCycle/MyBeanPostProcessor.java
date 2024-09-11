package com.example.demo.LifeCycle;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Slf4j
public class MyBeanPostProcessor  {

    @Autowired
    private LifeCycle lifeCycle;

    @PostConstruct
    public void test(){
        System.out.println("0000");
    }
    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor,此时还没有完成依赖注入");
    }
}
