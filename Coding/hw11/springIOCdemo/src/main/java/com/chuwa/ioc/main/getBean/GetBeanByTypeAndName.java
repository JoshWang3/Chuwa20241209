package com.chuwa.ioc.main.getBean;

import com.chuwa.ioc.component.Car;
import com.chuwa.ioc.component.Make;
import com.chuwa.ioc.component.impl.BMW;
import com.chuwa.ioc.component.impl.Coupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GetBeanByTypeAndName {

    @Autowired
    private Coupe coupe1; // no ambiguity in type

    @Autowired
    private Car coupe;  // ambiguity in type -- no qualifier -- search for primary

    @Autowired
    private Car hatchback; // ambiguity in type -- no qualifier -- search for primary

    @Autowired
    @Qualifier("sUV")
    private Car bigCar; // ambiguity in type with qualifier

    @Autowired
    private Car primaryCar; // primary

    @Autowired
    private Make BMW;   // by name

    @Autowired
    private Make mercedes; // by name

    @Autowired
    private Make lexus; // by name

    public void printMessage() {

        System.out.println("By type: ");
        coupe1.printCarInfo();

        System.out.println("By type no qualifier by @Primary: ");
        coupe.printCarInfo();
        hatchback.printCarInfo();

        System.out.println("By @Qualifier: ");
        bigCar.printCarInfo();

        System.out.println("By @Primary: ");
        primaryCar.printCarInfo();

        System.out.println("By Name: ");
        BMW.printMakeInfo();
        mercedes.printMakeInfo();
        lexus.printMakeInfo();

    }
}
