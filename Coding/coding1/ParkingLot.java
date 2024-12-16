package com.chuwa.learn;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public Set<Car> cars = new HashSet<>();
    final int maxCapacity;

    public ParkingLot(int capacity) {
        this.maxCapacity = capacity;
    }

    public void carIn(Car car) {
        if (cars.size() > maxCapacity) {
            throw new RuntimeException("parkingLot is Full");
        }
        cars.add(car);
    }

    public void carOut(Car car) {
        cars.remove(car);
    }

    public class Car {
        String color;
        //...
        public Car(String color) {
            this.color = color;
        }
    }
}
