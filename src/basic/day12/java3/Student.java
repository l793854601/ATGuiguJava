package basic.day12.java3;

public class Student extends Person {
    String major;
    int id = 20;

    public Student() {

    }

    public Student(String major) {
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void eat() {
        System.out.println("学生，多吃有营养的食物");
    }

    public void study() {
        System.out.println("学生，学习知识");

        //  eat被子类重写了，因此如果想调用父类中的eat方法，需要显式使用super
        eat();
        super.eat();

        //  子类没有重写walk方法，因此下面两行代码等价，调用的实际上都是父类的walk方法
        walk();
        super.walk();
    }

    public void show() {
        System.out.println("name = " + name + ", age = " + age);
        System.out.println("id = " + id);   //  省略了this，相当于this.age
        System.out.println("this.id = " + this.id);
        System.out.println("super.id = " + super.id);
    }
}
