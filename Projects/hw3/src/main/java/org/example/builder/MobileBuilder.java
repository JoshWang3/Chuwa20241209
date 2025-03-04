package org.example.builder;

public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Mobile Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Mobile Seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
