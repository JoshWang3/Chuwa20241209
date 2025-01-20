package com.example.learn.bean.scope;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public String getScope() {
        return "It's a Singleton Bean";
    }
}

