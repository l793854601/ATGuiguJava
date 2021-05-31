package basic.day10.package1;

/*
    类的结构之三：构造器（构造方法、constructor）的使用

    1.构造器的作用：
    1）创建对象（类的实例）
    2）初始化对象的属性

    2.说明：
    1）如果没有显式定义类的构造器，则系统默认提供一个空参的构造器
    2）定义构造器的格式：权限修饰符 类名(形参列表) {}
    3）一个类中定义的多个构造器，彼此构成重载（构造器1、构造器2、构造器3）
    4）一旦我们显式定义了类的构造器后，系统则不再提供默认的空参构造器
    5）一个类中至少会有一个构造器（系统默认提供的，或者自定义的）
    "系统提供"：实际上是从父类继承过来的，Person的父类是Object，默认的无参构造器实际是从Object类继承而来
    "系统提供"的默认构造器，其修饰权限跟随本类的修饰权限
 */

class Person {
    String name;
    int age;

    //  构造器1
    public Person() {
        System.out.println("Person()");
    }

    //  构造器2
    public Person(String n) {
        name = n;
    }

    //  构造器3
    public Person(String n, int a) {
        name = n;
        age = a;
    }

    public void eat() {
        System.out.println("人吃饭");
    }

    public void study() {
        System.out.println("人学习");
    }
}

public class PersonTest {
    public static void main(String[] args) {
        //  创建类的对象：new + 构造器
        Person p = new Person();
        p.eat();

        Person p1 = new Person("Tom");
        System.out.println(p1.name);
    }
}
