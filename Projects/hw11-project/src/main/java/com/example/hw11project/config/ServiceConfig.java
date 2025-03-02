package com.example.hw11project.config;

import com.example.hw11project.service.beanRegistrationDemo.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean // @Bean是方法级别注解，Spring会调用这个方法并将返回的对象注册为一个bean
    public BeanService beanService() {
        return new BeanService();
    }
}
