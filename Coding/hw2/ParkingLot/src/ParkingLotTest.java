public class ParkingLotTest {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 10, 10, 5);

        Vehicle car1 = new Vehicle("JA66666", VehicleType.SMALL);
        Vehicle car2 = new Vehicle("JA99999", VehicleType.MEDIUM);
        Vehicle car3 = new Vehicle("JA00000", VehicleType.LARGE);

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car3);

        parkingLot.unparkVehicle(car2);
        parkingLot.unparkVehicle(new Vehicle("NOT_EXIST", VehicleType.SMALL));
    }
}
