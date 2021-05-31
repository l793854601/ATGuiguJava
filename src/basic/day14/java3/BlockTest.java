package basic.day14.java3;

/*
    类的成员之四：代码块（也叫初始化块）

    1.代码块的作用：用来初始化类、对象

    2.代码块如果有修饰的话，只能使用static

    3.分类、静态代码块、非静态代码块

    4.静态代码块：
        > 内部可以有输出语句
        > 随着类的加载而执行，而且只会执行一次
        > 作用：初始化类的信息
        > 如果一个类中定义了多个静态代码块，则按照声明的顺序先后执行
        > 静态代码块的执行，要优先于非静态代码块的执行
        > 静态代码块内，只能调用静态属性、静态方法，不能调用非静态属性、非静态方法

    5.非静态代码块：
        > 内部可以有输出语句
        > 随着对象的创建而执行
        > 每创建一个对象，就执行一次非静态代码块
        > 作用：可以在创建对象时，对对象的属性等进行初始化
        > 非静态代码块内，可以调用静态属性、静态方法，也能调用非静态属性、非静态方法
 */

class Person {
    //  属性
    String name;
    int age;
    static String desc = "我是一个人";

    //  静态代码块1
    static {
        System.out.println("Hello, static block - 1");
    }

    //  静态代码块2
    static {
        System.out.println("Hello, static block - 2");
        //  调用静态结构
        desc = "我是一个爱学习的人";
        info();
    }

    //  非静态代码块1
    {
        System.out.println("Hello, block - 1");
    }

    //  非静态代码块2
    {
        System.out.println("Hello, block - 2");
        //  调用非静态结构
        age = 1;
        eat();
        //  调用静态结构
        desc = "我是一个很爱学习的人";
        info();
    }

    //  构造器1
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //  方法
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void info() {
        System.out.println("我是一个快乐的人");
    }
}

public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        System.out.println(desc);
        Person.info();

        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.age);
        System.out.println(p2.age);
        Person.info();
    }
}
