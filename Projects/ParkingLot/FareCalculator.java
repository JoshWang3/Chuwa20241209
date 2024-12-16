// FareCalculator class for calculating fare
class FareCalculator {
    private double carRatePerHour;
    private double vanRatePerHour;
    private double truckRatePerHour;
    private double motorcycleRatePerHour;

    // Default constructor with default values
    public FareCalculator() {
        this.carRatePerHour = 10.0; // Default rate for cars
        this.vanRatePerHour = 15.0; // Default rate for vans
        this.truckRatePerHour = 20.0; // Default rate for trucks
        this.motorcycleRatePerHour = 5.0; // Default rate for motorcycles
    }

    // Constructor with custom rates
    public FareCalculator(double carRatePerHour, double vanRatePerHour, double truckRatePerHour, double motorcycleRatePerHour) {
        this.carRatePerHour = carRatePerHour;
        this.vanRatePerHour = vanRatePerHour;
        this.truckRatePerHour = truckRatePerHour;
        this.motorcycleRatePerHour = motorcycleRatePerHour;
    }

    // Getters and setters
    public double getCarRatePerHour() {
        return carRatePerHour;
    }

    public void setCarRatePerHour(double carRatePerHour) {
        this.carRatePerHour = carRatePerHour;
    }

    public double getVanRatePerHour() {
        return vanRatePerHour;
    }

    public void setVanRatePerHour(double vanRatePerHour) {
        this.vanRatePerHour = vanRatePerHour;
    }

    public double getTruckRatePerHour() {
        return truckRatePerHour;
    }

    public void setTruckRatePerHour(double truckRatePerHour) {
        this.truckRatePerHour = truckRatePerHour;
    }

    public double getMotorcycleRatePerHour() {
        return motorcycleRatePerHour;
    }

    public void setMotorcycleRatePerHour(double motorcycleRatePerHour) {
        this.motorcycleRatePerHour = motorcycleRatePerHour;
    }

    // Member function to calculate fare
    public double calculateFare(ParkingTicket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = ticket.getExitTime();
        long hoursParked = ChronoUnit.HOURS.between(entryTime, exitTime);
        // Adding 1 hour to the parked duration to ensure at least one hour is charged for payment
        if (hoursParked < 1)
            hoursParked=1;


        double ratePerHour;
        switch (ticket.getVehicle().getType()) {
            case "Car":
                ratePerHour = carRatePerHour;
                break;
            case "Van":
                ratePerHour = vanRatePerHour;
                break;
            case "Truck":
                ratePerHour = truckRatePerHour;
                break;
            case "Motorcycle":
                ratePerHour = motorcycleRatePerHour;
                break;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }

        return hoursParked * ratePerHour;
    }
}
