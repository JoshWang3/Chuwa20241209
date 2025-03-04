package org.chuwa.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FieldInjectionController {
    @Autowired
    private InjectionService injectionService;

    public void printMessage() {
        System.out.println("Field Injection: " + injectionService.getMessage());
    }
}