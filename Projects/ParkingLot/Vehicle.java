public class Vehicle {
    private String licensePlate;
    private String type;
    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
    //getter and setters

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, "Motorcycle");
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, "Car");
    }
}

class Van extends Vehicle {
    public Van(String licensePlate) {
        super(licensePlate, "Van");
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, "Truck");
    }
}

//VehicleFactory to creat instance of vehicle subclass
class VehicleFactory {
    public Vehicle createVehicle(String type, String licensePlate) {
        //convert type to uppercase
        switch (type) {
            case "VAN":
                return new Van(licensePlate);
            case "TRUCK":
                return new Truck(licensePlate);
            case "CAR":
                return new Car(licensePlate);
            case "MOTORCYCLE":
                return new Motorcycle(licensePlate);
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}
