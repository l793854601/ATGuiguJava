package basic.day11;

/*
    面向对象的特征之二：继承性

    一、继承性的好处：
    1.减少了代码的冗余，提高了代码的复用性
    2.便于功能的扩展
    3.为多态性的使用，提供了前提

    二、继承性的格式：class A extends B
    A：子类（派生类），subclass
    B：父类（超类、基类）superclass

    2.1 体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有（private也包括在内）的：属性、方法
        特别的，父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构。
        只是因为封装性的影响，使得子类不能直接调用父类私有的结构而已。

    2.2 子类继承父类以后，还可以声明自己特有的属性、方法，实现功能的扩展
        子类和父类的关系，不同于子集和集合的关系。
        extends：延展、扩展

    三、java中关于继承性的规定：
    1.一个类可以被多个子类继承（可以有多个子类）
    2.java中类的单继承性：一个类只能有一个父类（java不直接支持多继承，可以通过interface间接实现）
    3.子父类是相对的概念（子类是其子类的父类，父类是其父类的子类）
    4.子类直接继承的父类，称为：直接父类
      子类间接继承的父类，称为：间接父类
    5.子类继承了父类以后，子类就获取了直接父类以及所有间接父类中声明的属性、方法

    四、
    1.如果我们没有显式的声明一个类的父类的话，则此类继承自java.lang.Object类
    2.所有的java类（除java.lang.Object类之外）都直接或间接继承自java.lang.Object类
    3.意味着，所有的java类中都具有java.lang.Object类声明的功能（toString、equals、hashCode等）
 */

public class ExtendsTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(1);
        p1.eat();
        p1.breath();

        Student s1 = new Student();
        s1.eat();
        s1.study();
        s1.breath();
        s1.setAge(10);
        System.out.println(s1.getAge());

        Creature creature = new Creature();
        System.out.println(creature.toString());
    }
}
