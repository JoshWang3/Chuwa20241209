package com.chuwa.learn;

// Main class demonstrating all concepts
public class OOPExample {
    public static void main(String[] args) {
        // Encapsulation demonstration
        Vehicle myCar = new Car("Honda Civic");
        Vehicle myBike = new Bike("Yamaha");

        // Polymorphism: Different implementations of the same method
        myCar.start(); // Output: Honda Civic is starting with a key ignition
        myBike.start(); // Output: Yamaha is starting with a kickstart

        // Parent class reference pointing to a child class object
        Vehicle vehicle = new Car("Tesla");
        vehicle.start(); // Runtime Polymorphism: Tesla is starting with a key ignition
    }
}
