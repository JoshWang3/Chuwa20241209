package design_pattern.builder.demo1;

public class MobileBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("CarbonFiber");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather");
    }

    @Override
    public Bike produceBike() {
        return bike;
    }
}
