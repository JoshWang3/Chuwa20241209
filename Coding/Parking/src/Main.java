public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);

        Vehicle car = new Car("ABC999");
        Vehicle truck = new Truck("XYZ123");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);

        parkingLot.leaveVehicle(truck);
        parkingLot.leaveVehicle(car);

        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(car);
    }

}