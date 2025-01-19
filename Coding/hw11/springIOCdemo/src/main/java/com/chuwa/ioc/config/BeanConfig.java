package com.chuwa.ioc.config;

import com.chuwa.ioc.component.Car;
import com.chuwa.ioc.component.impl.Truck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.chuwa.ioc"})
public class BeanConfig {

    /**
     * bean
     */
    @Bean
    public Car truck() {
        return new Truck();
    }
}
