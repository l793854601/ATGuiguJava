package basic.day15.java2;

/*
    类的内部成员之五：内部类
    1.java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B成为外部类

    2.内部类的分类：成员内部类（静态、非静态）、局部内部类（方法内、代码块内、构造器内）

    3.成员内部类：
        一方面，作为外部类的成员：
            > 可以调用外部类的结构（属性、方法）
            > 可以用static修饰
            > 可以用四种权限（public、缺省、protected、private）修饰

        另一方面，作为一个类：
            > 类内可以定义属性、方法、构造器等
            > 可以被final修饰，表示此类不能被继承（不使用final修饰，则可以被继承）
            > 可以被abstract修饰，表示此类不能被实例化

     4.关注如下的3个问题：
        4.1 如何实例化成员内部类的对象
        4.2 如何在成员内部类中区分调用外部类的结构
        4.3 开发当中，局部内部类的使用
 */

class Person {

    String name = "小明";
    int age;

    public void eat() {
        System.out.println("人吃饭");
    }

    //  静态成员内部类
    static class Dog {
        String name;
        int age;

        public void show() {
            System.out.println("卡拉是条狗");
        }
    }

    //  非静态成员内部类
    class Bird {
        String name = "杜鹃";

        public Bird() {

        }

        public void sing() {
            System.out.println("我是一只小小鸟");
            eat();  //  调用外部类的非静态属性
        }

        public void display(String name) {
            System.out.println(name);   //  方法的形参
            System.out.println(this.name);  //  内部类的属性
            System.out.println(Person.this.name);   //  外部类的属性
        }
    }

    {
        //  局部内部类
        class BB {

        }
    }

    public Person() {
        //  局部内部类
        class CC {

        }
    }

    public void method() {
        //  局部内部类
        class AA {

        }
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        //  创建Dog（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.show();

        //  创建Bird（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
        bird.display("黄鹂");

        Person p1 = new Person() {

        };

        System.out.println(p.getClass().getName());
        System.out.println(p1.getClass().getName());
    }
}