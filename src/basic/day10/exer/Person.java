package basic.day10.exer;

public class Person {
    private int age;
    private String name;

    public Person() {
        age = 18;
    }

    public Person(int a, String n) {
        age = a;
        name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            System.out.println("传入的数据非法");
            return;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
