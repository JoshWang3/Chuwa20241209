package org.example;

public class Inheritance extends Encapsulation {

    // Student

    private String studentId;

    Inheritance(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    // Overriding
    @Override
    public String print() {
        return super.print() + ", Student ID: " + studentId;
    }

    // Overloading
    public String print(String message) {
        return message + " " + super.print() + ", Student ID: " + studentId;
    }
}
