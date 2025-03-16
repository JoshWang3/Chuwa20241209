package com.example.hw11Q15demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/field")
    public String getMessage() {
        return "Field Injection: " + messageService.getMessage();
    }
}
