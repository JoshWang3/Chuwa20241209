package com.chuwa.learn;

// Parent class demonstrating Inheritance
class Vehicle {
    private final String name; // Encapsulation: Private field

    public Vehicle(String name) {
        this.name = name;
    }

    public void start() { // Parent method
        System.out.println(name + " is starting");
    }

    public String getName() {
        return name;
    }
}
