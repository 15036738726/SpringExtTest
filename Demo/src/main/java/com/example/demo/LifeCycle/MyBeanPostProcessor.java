package com.example.demo.LifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycle")) {
            log.info("postProcessBeforeInitialization---" + beanName);
            //如果特定的bean实例化完成后,还未执行InitializingBean.afterPropertiesSet()方法之前,有一些其他操作,可以在这里实现
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("lifeCycle")) {
            log.info("postProcessAfterInitialization---" + beanName);
            //如果特定的bean实例化完成,InitializingBean.afterPropertiesSet()方法执行后,有一些其他操作,可以在这里实现
        }
        return bean;
    }
}
