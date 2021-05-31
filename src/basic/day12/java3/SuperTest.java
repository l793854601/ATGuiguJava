package basic.day12.java3;

/*
    super关键字的使用
    1.super：理解为父类的

    2.super可以用来调用：属性、方法、构造器

    3.super调用属性、方法：
        3.1 我们可以在子类的方法或构造器中，通过使用"super.属性"或"super.方法"的方式，显式的调用父类中声明的属性或方法。
            通常情况下，我们习惯省略"super."
        3.2 特殊情况：当子类与父类定义了同名的属性时，我们要想在子类中调用父类中声明的属性，则必须
            显式的使用"super.属性"的方式，表明调用的是父类中声明的属性
        3.3 特殊情况：当子类重写了父类中给的方法以后，我们想在子类的方法中调用父类中被重写的方式，则必须
            显式的使用"super.方法"的方式，表明调用的是父类中被重写的方法

     4.super调用构造器：
        4.1 我们可以在子类的构造器中，使用"super(形参列表)"的方式，调用父类中声明的指定的构造器
        4.2 "super(形参列表)"必须使用在子类构造器的首行
        4.3 我们在类的构造器中，针对于"super(形参列表)"或"this(形参列表)"，只能二选一（构造器中最多只能调用一个其他构造器）
        4.4 当我们在类的构造器中，没有显式的使用"super(形参列表)"或"this(形参列表)"，则默认调用父类的公参构造器（super();）
        4.5 在类的多个构造器中，至少有一个类的构造器显式或隐式的使用了"super(形参列表)"，调用了父类的构造器
 */

public class SuperTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.show();
        s1.study();

        Student s2 = new Student("Tom", 21, "IT");
        s2.show();

        Student s3 = new Student("IT");

        Son son = new Son();
    }
}
