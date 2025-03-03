package Chuwa20241209.MavenProject.DesignPattern.Builder;

public class MobileBuilder extends Builder {

    public void buildFrame() {
        bike.setFrame("Carbon fiber frame");
    }

    public void buildSeat() {
        bike.setSeat("Leather seat");
    }

    public Bike createBike() {
        return bike;
    }
}
