package com.example.demo.importAnno.ImportBeanDefinitionRegistrar;

import com.example.demo.entity.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class UserImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    // 都是从父类ImportBeanDefinitionRegistrar中拷贝出的方法
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        this.registerBeanDefinitions(importingClassMetadata, registry);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 构建出自己想要的Bean内容,可以自由赋值
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(User.class).addPropertyValue("username","张三丰").getBeanDefinition();
        // 自定义bean的名称
        registry.registerBeanDefinition("myUser",beanDefinition);
    }
}
