package com.chuwa.ioc.main.beanScope;

import com.chuwa.ioc.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("**** Bean Scope Demo ****");
        BeanScope beanScope = (BeanScope) applicationContext.getBean("beanScope");

        // Singleton
        beanScope.printSingletonIsSame();

        // Prototype
        beanScope.printPrototypeIsSame();
    }
}
