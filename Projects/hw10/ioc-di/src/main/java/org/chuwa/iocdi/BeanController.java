package org.chuwa.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BeanController {
    @Autowired
    private ComponentService componentService;

    @Autowired
    private BeanService beanService;

    public void displayBeanTypes() {
        System.out.println(componentService.getName());
        System.out.println(beanService.getName());
    }
}
