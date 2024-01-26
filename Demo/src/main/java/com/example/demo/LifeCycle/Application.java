package com.example.demo.LifeCycle;

import com.example.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将 LifeCycle 注册到容器中
        applicationContext.register(Application.class);
        applicationContext.refresh();

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        // 关闭上下文，触发销毁操作
        applicationContext.close();
        /**
         * LifeCycle对象被创建了
         * 14:14:34.652 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'user'
         * Aware接口起作用，setApplicationContext被调用了，此时user=User(username=null)
         * @PostConstruct注解起作用，postConstruct方法被调用了
         * InitializingBean接口起作用，afterPropertiesSet方法被调用了
         * @Bean#initMethod()起作用，initMethod方法被调用了
         * 14:14:34.679 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@3fd7a715, started on Thu Jan 25 14:14:34 CST 2024
         * @PreDestroy注解起作用，preDestroy方法被调用了
         * DisposableBean接口起作用，destroy方法被调用了
         * @Bean#destroyMethod()起作用，destroyMethod方法被调用了
         */
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public LifeCycle lifeCycle() {
        return new LifeCycle();
    }

    @Bean
    public User user() {
        return new User();
    }

}