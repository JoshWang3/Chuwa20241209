import lot.ParkLots;
import vehicle.Sedan;
import vehicle.Truck;
import vehicle.Vehicle;

public class Client {
    public static void main(String[] args) {
        ParkLots parkingLot = new ParkLots(5);

        Vehicle car = new Sedan("fasdf", "blue");
        Vehicle truck = new Truck("ewqr", "green");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);

        parkingLot.leaveVehicle(truck);
        parkingLot.leaveVehicle(car);

        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(car);
    }
}
