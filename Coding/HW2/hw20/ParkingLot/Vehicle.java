package Chuwa20241209.Coding.HW2.hw20.ParkingLot;

// type safe and ensures consistency
enum VehicleType {
    MOTORCYCLE, CAR, BUS
}

abstract public class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

// or declare Car.java as public class
class Car extends Vehicle {
    public Car(String licensePlate) {
        // or use setLicensePlate, setVehicleType if included in Vehicle class
        super(licensePlate, VehicleType.CAR);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }
}

class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, VehicleType.BUS);
    }
}
