package com.chuwa.ioc.main.beanScope;

import com.chuwa.ioc.component.impl.Coupe;
import com.chuwa.ioc.component.impl.Hatchback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanScope {

    @Autowired
    private Coupe coupe1;

    @Autowired
    private Coupe coupe2;

    public void printSingletonIsSame(){
        boolean flag = coupe1 == coupe2;
        System.out.println("Singleton compare two beans: " + flag); // true
    }

    @Autowired
    private Hatchback hatchback1;

    @Autowired
    private Hatchback hatchback2;

    public void printPrototypeIsSame(){
        boolean flag = hatchback1 == hatchback2;
        System.out.println("Prototype compare two beans: " + flag); // true
    }
}
