package com.example.learn.bean.config;

import com.example.learn.bean.service.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "beanServiceB")
    public ServiceB serviceB() {
        return new ServiceB();
    }
}
