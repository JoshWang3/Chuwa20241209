package HW2.ShortQuestion;

public class Polymorphism {

    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.makeSound();

        Animal animal2 = new Animal();
        animal2.makeSound();
    }
}
