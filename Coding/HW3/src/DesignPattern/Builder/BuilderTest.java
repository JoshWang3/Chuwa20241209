package DesignPattern.Builder;

public class BuilderTest {
    public static void main(String[] args) {
        House house = new House.Builder("Concrete", "Wood", "Tiles")
                .setGarage(true)
                .setSwimmingPool(true)
                .setGarden(false)
                .build();

        System.out.println(house);
    }
}
