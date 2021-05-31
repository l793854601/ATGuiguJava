package basic.day10.java2;

/*
    this关键字的使用
    1.this可以用来调用属性、方法、构造器

    2.this修饰属性、方法：
      this理解为：当前对象，或当前正在创建的对象（构造器）

      2.1 在类的方法中，可以使用"this.属性"和"this.方法"的方式，调用当前对象属性、方法。
      但是，通常情况下，我们都选择省略"this."。
      如果方法的形参和类的属性同名时，我们必须显式使用"this.属性"，来指明当前调用的变量是属性。

      2.2 在类的构造器中，可以使用"this.属性"和"this.方法"的方式，调用当前正在创建的对象属性、方法。
      但是，通常情况下，我们都选择省略"this."。
      如果构造器的形参和类的属性同名时，我们必须显式使用"this.属性"，来指明当前调用的变量是属性。

    3.this调用构造器
      1）我们再类的构造器中，可以显式使用"this(形参列表)"的方式，调用本类中指定的其它构造器
      2）构造器中不可以通过"this(形参列表)"的方式调用自己
      3）如果一个类中有N个构造器，则最多有N-1个构造器中使用"this(形参列表)"的方式，调用本类中指定的其它构造器
         两个构造器不能彼此调用"this(形参列表)"，只能一个构造器调用定一个构造器
      4）规定：使用"this(形参列表)"，必须放在构造器内部的首行
      5）构造器内部，最多只能使用一次"this(形参列表)"的方式调用其他构造器，不可以多次调用其他构造器
 */

class Person {
    private String name;
    private int age;

    public Person() {
        this(null, 0);
    }

    public Person(String name) {
        this(name, 0);
    }

    public Person(int age) {
        this(null, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

        //  仅做演示
        String info = "Person对象初始化时，根据业务，需要执行1 2 3 4步骤，一共40行代码";
        System.out.println(info);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void live() {
//        this.eat();
//        this.study();
        eat();
        study();
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
        Person p1 = new Person();
        p1.setAge(1);
        System.out.println(p1.getAge());
        p1.live();

        new Person("Tom");
        new Person(10);
        new Person("Tom", 10);
    }
}
