package com.example.hw11Q15demo;

import org.springframework.stereotype.Component;

@Component
public class CasualGreeting implements Greeting {
    @Override
    public String greet() {
        return "Hey, what's up?";
    }
}
