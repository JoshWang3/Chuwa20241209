package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ThreadTestController {

    @GetMapping("/process")
    public String process() throws InterruptedException {
        // Simulate a time-consuming operation
        Thread.sleep(1000);
        return "Request done by thread: " + Thread.currentThread().getName();
    }
}