package com.chuwa.ioc.component.impl;

import com.chuwa.ioc.component.Car;

public class Truck implements Car {
    @Override
    public void printCarInfo() {
        System.out.println("This is Truck");
    }

    public void init() {
        System.out.println("init method inside Truck");
    }

    public void destroy() {
        System.out.println("destroy method inside Truck");
    }
}
