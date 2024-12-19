package org.example.builder;

public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Ofo Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Ofo Seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
