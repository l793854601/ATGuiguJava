package basic.day15.java1;

/*
    接口的使用:

    1.接口使用interface来定义

    2.在java中，接口和类是并列的两个结构

    3.如何定义接口：定义接口的成员
        3.1 JDK7及以前：只能定义全局常量、抽象方法
            > 全局常量：public static final，但是书写是可以不写
            > 抽象方法：public abstract

        3.2 JDK8：除了可定义全局常量、抽象方法之前，还可以定义静态方法、默认方法

    4.接口中不能定义构造器：意味着接口不可以实例化

    5.java开发中，接口都通过让类去实现（implements）的方式来使用
      如果实现类覆盖了接口中的所有方法，则此实现类就可以实例化
      如果实现类没有覆盖接口中的所有方法，则此实现类仍然为一个抽象类

    6.java类可以实现多个接口 ---> 弥补了java类的单继承性的局限性
      格式：class AA extends BB implements CC, DD, EE...

    7.接口与接口之间，是可以继承的，而且是可以多继承的

    8.接口的具体使用，体现了多态性

    9.接口，实际上是可以看成一种规范、契约

    面试题：抽象类和接口有哪些异同
 */

interface Flyable {
    //  全局常量
    public static final int MAX_SPEED = 7900;   //  第一宇宙速度
    int MIN_SPEED = 1;  //  可省略public static final

    //  抽象方法
    public abstract void fly();

    void stop();    //  可省略public abstract
}

interface Attackable {
    void attack();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

abstract class Kite implements Flyable {
    @Override
    public void fly() {

    }
}

class Bullet extends Object implements Flyable, Attackable {

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}

interface AA {
    void method1();
}

interface BB {
    void method2();
}

interface CC extends AA, BB {

}

class CClass implements CC {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        Plane plane = new Plane();
        plane.fly();
        plane.stop();
        System.out.println(plane.MAX_SPEED);
        System.out.println(plane.MIN_SPEED);
    }
}
