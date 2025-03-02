package com.example.aop_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/test/{name}")
    public String testMethod(@PathVariable("name") String param) {
        return "Hello, " + param;
    }
}