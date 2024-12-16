public class Polymorphism {
    public static void main(String[] args) {
        Animal bird = new Bird();
        Animal fish = new Fish();

        bird.move();
        fish.move();
    }
}

class Animal {
    public void move() {
        System.out.println("Animals move in different ways");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("Flapping wings to fly!");
    }
}

class Fish extends Animal {
    @Override
    public void move() {
        System.out.println("Swimming in the water!");
    }
}
