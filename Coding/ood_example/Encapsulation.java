public class Encapsulation {
    public static void main(String[] args) {
        Person person = new Person("Sherry");
        person.setAge(20);
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative!");
        }
    }

    public int getAge() {
        return age;
    }
}
