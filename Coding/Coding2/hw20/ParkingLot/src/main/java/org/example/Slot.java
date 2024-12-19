package org.example;

public class Slot {
    String type;
    Vehicle vehicle;
    String ticketId;
    public Slot(String type) {
        this.type = type;
        this.vehicle=null;
        this.ticketId=null;
    }
}