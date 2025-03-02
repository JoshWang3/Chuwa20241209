package com.chuwa.learn.Builder;

// Usage
public class BuilderTest {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .build();

        System.out.println(computer);
    }
}
