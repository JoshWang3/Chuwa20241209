package HW2.parkinglot.model;

import HW2.parkinglot.enums.ParkingSlotType;

import java.util.Date;

public  class Entrance extends Gate{
    public ParkingTicket generateParkingTicket(Vehicle vehicle, int levelId, int slotId, ParkingSlotType slotType) {
        ParkingTicket ticket = new ParkingTicket();
        ticket.setTicketNumber((int) (Math.random() * 100000));
        ticket.setLevelId(levelId);
        ticket.setSlotId(slotId);
        ticket.setParkingSlotType(slotType);
        ticket.setEntryDateTime(new Date());
        vehicle.setParkingTicket(ticket);
        return ticket;
    }
}
