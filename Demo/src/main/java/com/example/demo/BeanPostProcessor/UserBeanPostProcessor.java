package com.example.demo.BeanPostProcessor;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class UserBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 如果Bean的类型是User，那么就设置这个对象的username属性
        if (bean instanceof User) {
            log.info("postProcessBeforeInitialization---" + beanName);
            //如果特定的bean实例化完成后,还未执行InitializingBean.afterPropertiesSet()方法之前,有一些其他操作,可以在这里实现
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            log.info("postProcessAfterInitialization---" + beanName);
            ((User) bean).setUsername("张三丰");
            //如果特定的bean实例化完成,InitializingBean.afterPropertiesSet()方法执行后,有一些其他操作,可以在这里实现
        }
        return bean;
    }
}
