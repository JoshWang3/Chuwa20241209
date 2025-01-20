package com.example.hw11Q15demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanRegistrationDemoController {

    private final ComponentService componentService;
    private final BeanService beanService;

    public BeanRegistrationDemoController(ComponentService componentService, BeanService beanService) {
        this.componentService = componentService;
        this.beanService = beanService;
    }

    @GetMapping("/bean-registration")
    public String demonstrateBeanRegistration() {
        return "Component Service: " + componentService.getMessage() + "<br>" +
                "Bean Service: " + beanService.getMessage();
    }
}