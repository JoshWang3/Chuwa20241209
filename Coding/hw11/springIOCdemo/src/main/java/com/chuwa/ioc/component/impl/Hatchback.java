package com.chuwa.ioc.component.impl;

import com.chuwa.ioc.component.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hatchback")
@Scope("prototype")
public class Hatchback implements Car {
    @Override
    public void printCarInfo() {
        System.out.println("This is Hatchback");
    }
}