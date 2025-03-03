package com.example.learn.bean.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Component registration
@Component("serviceBBean")
@Primary
public class ServiceB {
    public String getMessage() {
        return "Message from ServiceB";
    }
}
