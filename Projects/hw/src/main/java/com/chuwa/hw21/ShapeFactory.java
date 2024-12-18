package com.chuwa.hw21;

public class ShapeFactory {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
