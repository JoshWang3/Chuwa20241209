package com.chuwa.ioc.main.injectionType;

import com.chuwa.ioc.component.impl.Coupe;
import com.chuwa.ioc.component.impl.Hatchback;
import com.chuwa.ioc.component.impl.Sedan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DIType {

    @Autowired
    private Coupe coupe; // DI by @Autowired

    private Hatchback hatchback;

    private Sedan sedan;

    // DI by constructor
    public DIType(Hatchback hatchback) {
        this.hatchback = hatchback;
    }

    // DI by Setter
    @Autowired
    public void setSedan(Sedan sedan) {
        this.sedan = sedan;
    }

    public void printCarsInfo() {
        coupe.printCarInfo();
        hatchback.printCarInfo();
        sedan.printCarInfo();
    }
}
