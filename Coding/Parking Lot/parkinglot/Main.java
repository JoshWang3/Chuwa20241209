package parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        // 创建测试车辆
        Vehicle car1 = new Vehicle("AB1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("CD5678", VehicleType.CAR);

        // 测试停车
        System.out.println("Remaining spots: " + parkingLot.getAvailableSpots());

        Ticket ticket1 = parkingLot.parkVehicle(car1);
        if (ticket1 != null) {
            System.out.println("Car 1 has been successfully parked. Ticket ID: " + ticket1.getTicketId());
        } else {
            System.out.println("Failed to park Car 1 - No available spots");
        }

        Ticket ticket2 = parkingLot.parkVehicle(car2);
        if (ticket2 != null) {
            System.out.println("Car 2 has been successfully parked. Ticket ID: " + ticket2.getTicketId());
        } else {
            System.out.println("Failed to park Car 2 - No available spots");
        }

        System.out.println("Remaining spots:" + parkingLot.getAvailableSpots());

        // 取车测试
        if (parkingLot.removeVehicle(ticket1.getTicketId())) {
            System.out.println("Car 1 has successfully left the parking lot.");
        } else {
            System.out.println("Failed to remove Car 1.");
        }

        System.out.println("Remaining spots: " + parkingLot.getAvailableSpots());
    }
}
