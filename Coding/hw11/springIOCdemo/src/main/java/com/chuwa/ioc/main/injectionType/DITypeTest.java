package com.chuwa.ioc.main.injectionType;

import com.chuwa.ioc.component.impl.Sedan;
import com.chuwa.ioc.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DITypeTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("**** Bean Injection Demo ****");
        DIType dIType = (DIType) applicationContext.getBean("DIType");

        dIType.printCarsInfo();
    }
}
