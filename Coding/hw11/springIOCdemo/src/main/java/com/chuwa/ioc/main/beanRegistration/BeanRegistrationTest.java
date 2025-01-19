package com.chuwa.ioc.main.beanRegistration;

import com.chuwa.ioc.component.impl.Coupe;
import com.chuwa.ioc.component.impl.Truck;
import com.chuwa.ioc.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanRegistrationTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("**** Bean Registration Demo ****");
        // @Bean
        Truck truck = (Truck) applicationContext.getBean("truck");
        truck.printCarInfo();

        // @Component
        Coupe coupe = (Coupe) applicationContext.getBean("coupe");
        coupe.printCarInfo();
    }
}
