package com.chuwa.ioc.component.impl;

import com.chuwa.ioc.component.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sUV")
public class SUV implements Car {
    @Override
    public void printCarInfo() {
        System.out.println("This is SUV");
    }
}