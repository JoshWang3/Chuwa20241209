package org.chuwa.springaopdemo.service.impl;

import org.chuwa.springaopdemo.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("spanishGreetingService")
public class SpanishGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hola, " + name + "!";
    }
}
