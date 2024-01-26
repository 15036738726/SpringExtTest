package com.example.demo.spi;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 自动装配说白了就是SPI机制的一种运用场景,这也说明了为什么springboot中需要自动装配的全路径对应的key都是EnableAutoConfiguration  因为这里传入的类的全限名将在文件中作为key
        List<String> classNames = SpringFactoriesLoader.loadFactoryNames(MyEnableAutoConfiguration.class, MyEnableAutoConfiguration.class.getClassLoader());
        classNames.forEach(System.out::println);
        /**
         * com.example.demo.entity.User
         * com.example.demo.entity.Admin
         */
    }
}
