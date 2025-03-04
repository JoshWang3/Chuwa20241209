package org.chuwa.iocdi;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public  class ScopeService {
    public ScopeService() {
        System.out.println("ScopeService instance created.");
    }
}

@Component
@Scope("singleton")
class SingletonService {
    public SingletonService() {
        System.out.println("SingletonService instance created.");
    }
}

@Component
@Scope("prototype")
class PrototypeService {
    public PrototypeService() {
        System.out.println("PrototypeService instance created.");
    }
}
