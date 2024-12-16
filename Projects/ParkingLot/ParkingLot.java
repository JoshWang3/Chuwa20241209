class ParkingLot {
    private List<ParkingFloor> floors;
    private Map<String, ParkingTicket> ticketMap;
    private ParkingSpotManager spotManager;

    // Constructors
    public ParkingLot() {
        this.floors = new ArrayList<>();
        this.ticketMap = new HashMap<>();
        this.spotManager = new ParkingSpotManager();
    }

    // Getters and setters
    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Map<String, ParkingTicket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, ParkingTicket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public ParkingTicket getTicket(String ticketNumber) {
        return ticketMap.get(ticketNumber);
    }

    // Method to get all tickets
    public Map<String, ParkingTicket> getTickets() {
        return ticketMap;
    }

    // Updated method to get total free spots
    public int getTotalFreeSpots() {
        // definition
    }

    // Updated method to get total free spots by type
    public int getTotalFreeSpotsByVehicleType(String vehicleType) {
        // definition
    }

    public List<Vehicle> getCurrentVehicles() {
        // definition
    }

    // Additional methods for managing parking tickets
    public void addTicket(String ticketNumber, ParkingTicket ticket) {
        ticketMap.put(ticketNumber, ticket);
    }

    public void removeTicket(String ticketNumber) {
        ticketMap.remove(ticketNumber);
    }

    // Updated method to get the parking spot for a given vehicle
    public ParkingSpot getSpotForVehicle(Vehicle vehicle) {
        // definition
    }

    public int getTotalSpots() {
        int totalSpots = 0;
        for (ParkingFloor floor : floors) {
            totalSpots += floor.getSpots().size();
        }
        return totalSpots;
    }

    // Updated method to get the total occupied spots
    public int getOccupiedSpots() {
        int occupiedSpots = 0;
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spotManager.isOccupied(spot)) {
                    occupiedSpots++;
                }
            }
        }
        return occupiedSpots;
    }

    public boolean isLicensePlatePresent(String licensePlate) {
        for (ParkingTicket ticket : ticketMap.values()) {
            if (ticket.getVehicle().getLicensePlate().equals(licensePlate)) {
                return true; // License plate already present
            }
        }
        return false; // License plate not found
    }
}
