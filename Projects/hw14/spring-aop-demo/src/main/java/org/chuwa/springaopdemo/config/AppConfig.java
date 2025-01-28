package org.chuwa.springaopdemo.config;

import org.chuwa.springaopdemo.service.GreetingService;
import org.chuwa.springaopdemo.service.impl.EnglishGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("manualEnglishService")
    public GreetingService manualEnglishService() {
        return new EnglishGreetingService();
    }
}
