package basic.day13.java1;

/*
    java.lang.Object类：

    1.Object类是所有java类的根父类

    2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类

    3.Object类中的功能（属性、方法）就具有通用性
        属性：无
        方法：equals()、toString()、getClass()、hashCode()、clone()、finalize()
              wait()、notify()、notifyAll()
            其中：clone()用的较少（参考Objective-C中的copy）
                  finalize()不会主动调（垃圾回收机制）
                  wait()、notify()、notifyAll()与多线程有关

    4.Object类只声明的一个空参构造器
 */

class Order {

}

public class ObjectTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getClass());
        System.out.println(order.getClass().getSuperclass());
    }
}
