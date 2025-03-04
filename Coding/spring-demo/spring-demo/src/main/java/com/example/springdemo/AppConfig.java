package com.example.springdemo;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
class AppConfig {

    @Bean(name = "customService")
    public MyService customService() {
        return new MyService();
    }

    @Bean(name = "anotherService")
    public MyService anotherService() {
        return new MyService();
    }
}