package design_pattern.builder.demo1;

public class Client {
    public static void main(String[] args) {
        Director d = new Director(new MobileBuilder());
        Bike b = d.constructBike();
        System.out.println(b.getFrame());
    }
}
