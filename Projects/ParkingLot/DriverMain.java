public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParkingLot parkingLot = new ParkingLot();
        ParkingLotInitializer parkingLotInitializer = new ParkingLotInitializer(parkingLot);
        parkingLotInitializer.initializeParkingLot(3, 30);

        ParkingSpotManager spotManager = new ParkingSpotManager();

        DisplayBoard displayBoard = new DisplayBoard(parkingLot);
        displayBoard.displayParkingLotStatus();

        MenuOptionHandler menuOptionHandler = new MenuOptionHandler(scanner, parkingLot, spotManager, displayBoard);
        menuOptionHandler.runMenu();
    }
}