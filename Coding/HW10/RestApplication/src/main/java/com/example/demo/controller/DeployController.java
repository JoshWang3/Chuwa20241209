package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeployController {

    // Simple hello world endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World! This is your deployed Spring Boot application.";
    }

    // Health check endpoint
    @GetMapping("/health")
    public String healthCheck() {
        return "Application is running successfully!";
    }
}
