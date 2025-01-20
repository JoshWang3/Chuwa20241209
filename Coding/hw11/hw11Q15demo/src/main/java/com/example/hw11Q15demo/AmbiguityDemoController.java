package com.example.hw11Q15demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmbiguityDemoController {

    // This will cause ambiguity
    @Autowired
    private Greeting ambiguousGreeting;

    // Resolving ambiguity by name
    @Autowired
    private Greeting formalGreeting;

    // Resolving ambiguity by @Qualifier
    @Autowired
    @Qualifier("casualGreeting")
    private Greeting qualifiedGreeting;

    @GetMapping("/ambiguity")
    public String demonstrateAmbiguity() {
        return "Ambiguous: " + (ambiguousGreeting != null ? ambiguousGreeting.greet() : "NULL") + "<br>" +
                "By Name: " + formalGreeting.greet() + "<br>" +
                "By Qualifier: " + qualifiedGreeting.greet();
    }
}
