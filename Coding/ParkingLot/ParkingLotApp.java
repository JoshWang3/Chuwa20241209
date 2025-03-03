public class ParkingLotApp {
    public static void main(String[] args) {
        // Create a parking lot with 5 parking spaces
        ParkingLot parkingLot = new ParkingLot(5);

        // Create a few cars
        Car car1 = new Car("ABC123", CarType.SMALL);
        Car car2 = new Car("XYZ456", CarType.MEDIUM);

        // Park the cars
        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);

        // Show parking lot status
        parkingLot.showParkingLotStatus();

        // Calculate parking fee
        ParkingFeeCalculator feeCalculator = new ParkingFeeCalculator();
        long fee = feeCalculator.calculateFee(car1);
        System.out.println("Car " + car1.getLicensePlate() + " parking fee: " + fee);

        // Remove car
        parkingLot.removeCar("ABC123");
        parkingLot.showParkingLotStatus();
    }
}
