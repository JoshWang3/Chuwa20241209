package com.example.hw11Q15demo.beanscopes;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    private int count = 0;

    public int incrementAndGet() {
        return ++count;
    }
}
