package org.chuwa.springaopdemo.controller;

import org.chuwa.springaopdemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // Dependency injection by type
    @Autowired
    private GreetingService englishGreetingService;

    // Dependency injection by name (qualifier)
    @Autowired
    @Qualifier("spanishGreetingService")
    private GreetingService spanishGreetingService;

    @GetMapping("/greet/english")
    public String greetInEnglish(@RequestParam String name) {
        return englishGreetingService.greet(name);
    }

    @GetMapping("/greet/spanish")
    public String greetInSpanish(@RequestParam String name) {
        return spanishGreetingService.greet(name);
    }
}
