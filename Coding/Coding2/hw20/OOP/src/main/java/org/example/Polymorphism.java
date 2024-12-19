package org.example;

public class Polymorphism {

    // Animal
    public String name;

    public Polymorphism(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dog extends Polymorphism {
    public  String breed;
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Polymorphism {
    public  String type;
    public Cat(String name, String type) {
        super(name);
        this.type = type;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    // Overloading
    public void makeSound(int times) {
        System.out.println(name + " says:");
        for (int i = 0; i < times; i++) {
            System.out.println("Meow!");
        }
    }
}
