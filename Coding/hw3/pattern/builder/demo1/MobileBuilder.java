package builder.demo1;

public class MobileBuilder extends Builder{
    public void buildFrame() {
        bike.setFrame("carbon frame");
    }

    public void buildSeat() {
        bike.setSeat("Leather Seat");
    }

    public Bike createBike() {
        return bike;
    }
}
