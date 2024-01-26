package com.example.demo.importAnno.ImportBeanDefinitionRegistrar;

import com.example.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

// 导入 UserImportBeanDefinitionRegistrar
@Import(UserImportBeanDefinitionRegistrar.class)
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将 Application 注册到容器中
        applicationContext.register(Application.class);
        applicationContext.refresh();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.out.println("-----");
        // 通过容器名称获取
        User myUser = (User) applicationContext.getBean("myUser");
        System.out.println("获取到的Bean为" + myUser + "，属性username值为：" + myUser.getUsername());
        // 通过类型获取
        User user = applicationContext.getBean(User.class);
        System.out.println("获取到的Bean为" + user + "，属性username值为：" + user.getUsername());
    }

}