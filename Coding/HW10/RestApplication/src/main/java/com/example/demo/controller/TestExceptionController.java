package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestExceptionController {
    @GetMapping("/illegal")
    public String raiseIllegalArgumentException() {
        throw new IllegalArgumentException("Illegal argument happens");
    }

    @GetMapping("/null-pointer")
    public String raiseNullPointerException() {
        throw new NullPointerException("Null pointer happens");
    }

    @GetMapping("/generic")
    public String raiseGenericException() {
        throw new RuntimeException("Runtime exception happens");
    }
}
