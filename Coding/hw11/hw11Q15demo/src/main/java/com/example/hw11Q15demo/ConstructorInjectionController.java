package com.example.hw11Q15demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructorInjectionController {
    private final MessageService messageService;

    public ConstructorInjectionController(MessageService messageService) { // No explicit @Autowired annotation.
        this.messageService = messageService;
    }

    @GetMapping("/constructor")
    public String getMessage() {
        return "Constructor Injection: " + messageService.getMessage();
    }
}
