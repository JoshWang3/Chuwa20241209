package com.chuwa.spring_multithread_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Multi-thread Demo!";
    }
    @GetMapping("/process")
    public String process() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Processing in thread: " + threadName);
        return "Processed by: " + threadName;
    }
}
