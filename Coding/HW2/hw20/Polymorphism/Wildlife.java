package Chuwa20241209.Coding.HW2.hw20.Polymorphism;

class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

class Elephant {
    // Overloaded methods with different parameter lists
    public int walk(int a) {
        System.out.println("An elephant walks " + a + " steps");
        return a;
    }

    public String walk(String a) {
        System.out.println("An elephant walks in the " + a + " route");
        return a;
    }
}

public class Wildlife {
    public static void main(String[] args) {
        System.out.println("Runtime Polymorphism (Method Overriding): ");
        Animal myDog = new Dog();  // Upcasting: Dog is treated as an Animal
        Animal myCat = new Cat();  // Upcasting: Cat is treated as an Animal
        myDog.sound(); // Calls Dog's sound method: Output -> "Dog barks"
        myCat.sound(); // Calls Cat's sound method: Output -> "Cat meows"

        System.out.println("Compile-Time Polymorphism (Method Overloading): ");
        Elephant elephant = new Elephant();
        System.out.println(elephant.walk(5));         // Calls walk(int)
        System.out.println(elephant.walk("Jungle"));     // Calls walk(String)
    }
}
