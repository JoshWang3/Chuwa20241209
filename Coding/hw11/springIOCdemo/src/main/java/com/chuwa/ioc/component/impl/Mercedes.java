package com.chuwa.ioc.component.impl;

import com.chuwa.ioc.component.Make;
import org.springframework.stereotype.Component;

@Component
public class Mercedes implements Make {
    @Override
    public void printMakeInfo() {
        System.out.println("This is Mercedes");
    }
}
