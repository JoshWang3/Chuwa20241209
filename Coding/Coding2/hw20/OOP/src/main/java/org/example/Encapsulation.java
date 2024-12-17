package org.example;

public class Encapsulation {
    // Person
    private String name;
    private int age;

    Encapsulation(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String print() {
        return "Name: " + name + ", Age: " + age;
    }
}
