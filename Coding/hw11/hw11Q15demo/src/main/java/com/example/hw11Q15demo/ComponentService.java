package com.example.hw11Q15demo;

import org.springframework.stereotype.Component;

@Component
public class ComponentService {
    public String getMessage() {
        return "This is a service registered with @Component";
    }
}