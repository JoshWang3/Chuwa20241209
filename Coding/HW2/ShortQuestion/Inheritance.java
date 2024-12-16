package HW2.ShortQuestion;

public class Inheritance {

    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.makeSound();
        animal1.eat();

        Animal animal2 = new Animal();
        animal2.makeSound();
        animal2.eat();
    }
}
