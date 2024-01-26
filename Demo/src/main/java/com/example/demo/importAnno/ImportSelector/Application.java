package com.example.demo.importAnno.ImportSelector;

import com.example.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(UserImportSelector.class)
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将 Application 注册到容器中  目的是为了加载这个类上的@Import(UserImportSelector.class)
        applicationContext.register(Application.class);
        applicationContext.refresh();
        System.out.println("获取到的Bean为" + applicationContext.getBean(User.class));
        /**
         * 如今在看boot自动配置
         * @SpringBootApplication 中的自动配置注解 @EnableAutoConfiguration上有一个注解@Import({AutoConfigurationImportSelector.class})
         * 那么类路径下的项目依赖对象是如何加载到容器中的呢,就在AutoConfigurationImportSelector这个类中,
         * public class AutoConfigurationImportSelector implements DeferredImportSelector,而DeferredImportSelector是ImportSelector的子接口,所以
         * 在AutoConfigurationImportSelector中重写了selectImports注册方法 即org.springframework.boot.autoconfigure.AutoConfigurationImportSelector#selectImports
         * 这个重写之后的方法返回的是:return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
         * autoConfigurationEntry.getConfigurations()就是SPI机制下的,去加载对应的类全限定数据的方法,内部肯定调用了SpringFactoriesLoader.loadSpringFactories方法,返回了一大堆类的全限命名
         */
    }
}
