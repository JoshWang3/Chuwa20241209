package org.chuwa.springaopdemo.service.impl;

import org.chuwa.springaopdemo.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("englishGreetingService")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
