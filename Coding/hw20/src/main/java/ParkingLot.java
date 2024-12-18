import java.util.*;


public class ParkingLot {
    private List<ParkingSpot> spots;
    private Map<String, ParkingSpot> ticketMap;
    private static final int CAPACITY = 100;

    public ParkingLot() {
        spots = new ArrayList<>();
        ticketMap = new HashMap<>();
        for (int i = 0; i < CAPACITY; i++) {
            spots.add(new ParkingSpot("SPOT-" + i));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                if (spot.park(vehicle)) {
                    Ticket ticket = new Ticket(vehicle, spot);
                    ticketMap.put(ticket.getTicketId(), spot);
                    return ticket;
                }
            }
        }
        return null;
    }

    public boolean removeVehicle(String ticketId) {
        ParkingSpot spot = ticketMap.get(ticketId);
        if (spot != null && spot.isOccupied()) {
            spot.removeVehicle();
            ticketMap.remove(ticketId);
            return true;
        }
        return false;
    }


    public int getAvailableSpots() {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                count++;
            }
        }
        return count;
    }
}