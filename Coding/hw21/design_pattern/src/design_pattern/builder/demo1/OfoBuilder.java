package design_pattern.builder.demo1;

public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Metal");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Wood");
    }

    @Override
    public Bike produceBike() {
        return bike;
    }
}
