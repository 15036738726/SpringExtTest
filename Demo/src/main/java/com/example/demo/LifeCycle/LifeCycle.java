package com.example.demo.LifeCycle;

import com.example.demo.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycle implements InitializingBean,BeanPostProcessor, ApplicationContextAware, DisposableBean {

    @Autowired
    private User user;

    public LifeCycle() {
        System.out.println("LifeCycle对象被创建了,此时还没有完成依赖注入");
    }

    /**
     * 实现的 Aware 回调接口
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Aware接口起作用，setApplicationContext被调用了，此时完成依赖注入user=" + user);
    }

    // @PostConstruct注解的方法将会在依赖注入完成后被自动调用
    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct注解起作用，postConstruct方法被调用了");
    }

    /**
     * 实现 InitializingBean 接口
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口起作用，afterPropertiesSet方法被调用了");
    }

    /**
     * 通过 {@link Bean#initMethod()}来指定
     *
     * @throws Exception
     */
    public void initMethod() throws Exception {
        System.out.println("@Bean#initMethod()起作用，initMethod方法被调用了");
    }






    // @PreDestroy注解可以标记一个方法,在Bean销毁之前自动执行该方法
    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println("@PreDestroy注解起作用，preDestroy方法被调用了");
    }

    /**
     * 实现 DisposableBean 注解
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口起作用，destroy方法被调用了");
    }

    /**
     * 通过 {@link Bean#destroyMethod()}来指定
     *
     * @throws Exception
     */
    public void destroyMethod() throws Exception {
        System.out.println("@Bean#destroyMethod()起作用，destroyMethod方法被调用了");
    }


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("------1111");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("------2222");
        return bean;
    }

}
