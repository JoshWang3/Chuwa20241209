package com.example.learn.bean.service;

import org.springframework.stereotype.Component;

// Component registration
@Component
public class ServiceA {
    public String getMessage() {
        return "Message from ServiceA";
    }
}
