// ExitPanel class for vehicle exit
class ExitPanel {
    private ParkingLot parkingLot;
    private ParkingSpotManager spotManager;

    // Constructors
    public ExitPanel(ParkingLot parkingLot, ParkingSpotManager spotManager) {
        this.parkingLot = parkingLot;
        this.spotManager = spotManager;
    }

    // Getters and setters
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // Member function to process vehicle exit
    public void processExit(String licensePlate) {
        // Check if spotManager is not null before accessing its methods

        // Find the ticket associated with the provided license plate

        // Set exit time

        // Calculate the total hours parked

        // Calculate the fare using fare calculator


        // Generate the receipt

        // Free up the parking spot

        // Remove the ticket from the parking lot

        // Prompt user for payment method
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose an option for payment:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. Exit program");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                PaymentStrategy cashPayment = new CashPayment();
                CentralPaymentSystem.getInstance().processPayment(cashPayment, fare);
                break;
            case 2:
                PaymentStrategy cardPayment = new CardPayment();
                CentralPaymentSystem.getInstance().processPayment(cardPayment, fare);
                break;
            case 3:
                System.out.println("Exiting program...");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice of payment. Please try again.");
        }
    }

    // Helper function to find the parking ticket associated with the provided license plate
    private ParkingTicket findTicketByLicensePlate(String licensePlate) {
        for (ParkingTicket ticket : parkingLot.getTicketMap().values()) {
            if (ticket.getVehicle().getLicensePlate().equals(licensePlate)) {
                return ticket;
            }
        }
        return null; // Return null if no ticket found for the provided license plate
    }
}