package org.chuwa.iocdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public BeanService beanService() {
        return new BeanService();
    }
}
