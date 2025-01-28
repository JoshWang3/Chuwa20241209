package com.example.HelloWorldAOP.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String sayHello() {
        return "Hello, World!";
    }
}