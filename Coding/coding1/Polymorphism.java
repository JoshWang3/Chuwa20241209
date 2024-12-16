package coding1;

// Demonstrates coding1.Polymorphism (Method Overriding)
class Animal {
    void sound() {
        System.out.println("Animals make sounds");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("coding1.Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("coding1.Cat meows");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}

