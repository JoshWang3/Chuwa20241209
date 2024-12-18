package com.chuwa.learn;

// Subclass Car inheriting Vehicle
class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void start() { // Polymorphism: Method Overriding
        System.out.println(getName() + " is starting with a key ignition");
    }
}
