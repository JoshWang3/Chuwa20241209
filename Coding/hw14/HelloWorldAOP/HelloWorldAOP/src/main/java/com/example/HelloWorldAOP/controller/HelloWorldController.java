package com.example.HelloWorldAOP.controller;

import com.example.HelloWorldAOP.aspects.LogExecution;
import com.example.HelloWorldAOP.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@LogExecution
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public String hello() {
        return helloWorldService.sayHello();
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    /*
    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("Demonstrating exception logging");
    }
    */
}
