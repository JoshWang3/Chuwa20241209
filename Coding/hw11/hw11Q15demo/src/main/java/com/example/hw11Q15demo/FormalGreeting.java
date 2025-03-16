package com.example.hw11Q15demo;

import org.springframework.stereotype.Component;

@Component
public class FormalGreeting implements Greeting {
    @Override
    public String greet() {
        return "Good day, sir/madam.";
    }
}
