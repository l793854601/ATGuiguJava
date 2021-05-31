package basic.day14.java2;

/*
    一、单例设计模式：
    1.所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。

    2.如何实现？
        饿汉式、懒汉式

    3.区分饿汉式和懒汉式
        饿汉式：
            好处：线程安全
            坏处：对象提前被创建，占用空间

        懒汉式：
            好处：延迟对象创建，节省空间
            坏处：如果不做特殊处理，则线程不安全 ---> 到多线程内容时，再修改
 */

//  饿汉式：
class Bank {
    //  1.私有化类的构造器
    private Bank() {

    }

    //  2.内部创建类的对象
    //  要求次对象也必须是静态的
    private static Bank instance = new Bank();

    //  3.提供公共的静态方法，返回类的实例
    public static Bank getInstance() {
        return instance;
    }
}

public class SingletonTest1 {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
    }
}
