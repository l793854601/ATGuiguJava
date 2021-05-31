package basic.day11;

public class Student extends Person {
    String major;

    public Student() {
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public void study() {
        System.out.println("学习");
    }

    public void show() {
        System.out.println("name = " + name + ", age = " + getAge());
    }
}
