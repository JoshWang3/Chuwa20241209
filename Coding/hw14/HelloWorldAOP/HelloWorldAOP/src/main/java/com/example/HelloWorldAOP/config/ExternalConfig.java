package com.example.HelloWorldAOP.config;

import com.external.ExternalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalConfig {
    @Bean
    public ExternalService externalService() {
        return new ExternalService();
    }
}
