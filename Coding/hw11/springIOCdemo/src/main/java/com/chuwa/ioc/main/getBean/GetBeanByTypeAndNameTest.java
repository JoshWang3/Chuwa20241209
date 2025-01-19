package com.chuwa.ioc.main.getBean;

import com.chuwa.ioc.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GetBeanByTypeAndNameTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("**** Get Bean Demo ****");
        GetBeanByTypeAndName getBeanByTypeAndName = (GetBeanByTypeAndName) applicationContext.getBean("getBeanByTypeAndName");

        getBeanByTypeAndName.printMessage();
    }

}
