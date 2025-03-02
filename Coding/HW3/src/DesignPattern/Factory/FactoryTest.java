package DesignPattern.Factory;

public class FactoryTest {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("Car");
        car.design();
        car.manufacture();

        Vehicle bike = VehicleFactory.getVehicle("Bike");
        bike.design();
        bike.manufacture();
    }
}
