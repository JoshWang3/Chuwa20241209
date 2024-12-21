package DesignPattern.Factory;

public class Bike implements Vehicle{
    @Override
    public void design() {
        System.out.println("Designing a Bike");
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing a Bike");
    }
}
