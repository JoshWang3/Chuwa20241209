package com.chuwa.ioc.component.impl;

import com.chuwa.ioc.component.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sedan")
@Primary
public class Sedan implements Car {
    @Override
    public void printCarInfo() {
        System.out.println("This is Sedan");
    }
}