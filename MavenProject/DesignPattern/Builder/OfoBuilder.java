package Chuwa20241209.MavenProject.DesignPattern.Builder;

public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("Aluminium alloy frame");
    }

    public void buildSeat() {
        bike.setSeat("Rubber seat");
    }

    public Bike createBike() {
        return bike;
    }
}