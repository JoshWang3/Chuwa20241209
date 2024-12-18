package com.chuwa.learn;

// Subclass Bike inheriting Vehicle
class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println(getName() + " is starting with a kickstart");
    }
}
