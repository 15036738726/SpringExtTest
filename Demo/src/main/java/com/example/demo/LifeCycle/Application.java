package com.example.demo.LifeCycle;

import com.example.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

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
         * LifeCycle对象被创建了,此时还没有完成依赖注入
         * 14:20:34.058 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'user'
         * 14:20:34.059 [main] INFO org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker - Bean 'user' of type [com.example.demo.entity.User] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
         * Aware接口起作用，setApplicationContext被调用了，此时完成依赖注入user=User(username=xxxx)
         * @PostConstruct注解起作用，postConstruct方法被调用了
         * InitializingBean接口起作用，afterPropertiesSet方法被调用了
         * @Bean#initMethod()起作用，initMethod方法被调用了
         * 14:20:34.067 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'myBeanPostProcessor'
         * MyBeanPostProcessor,此时还没有完成依赖注入
         * ------1111
         * 0000
         * ------2222
         * 14:20:35.908 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@3b084709, started on Wed Sep 11 14:20:33 CST 2024
         * @PreDestroy注解起作用，preDestroy方法被调用了
         * DisposableBean接口起作用，destroy方法被调用了
         * @Bean#destroyMethod()起作用，destroyMethod方法被调用了
         */
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public LifeCycle lifeCycle() {
        return new LifeCycle();
    }

    // 为了执行MyBeanPostProcessor中的构造函数
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setUsername("xxxx");
        return user;
    }

}