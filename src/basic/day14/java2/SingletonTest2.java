package basic.day14.java2;

/*
    单例模式的懒汉式实现：
 */

class Order {
    //  1.私有化类的构造器
    private Order () {

    }

    //  2.声明当前类的实例，但不初始化
    //  此对象也必须声明为static的
    private static Order instance = null;

    //  3.声明一个public、static的返回当前类对象的静态方法
    //  此处如果不做特殊处理，则多线程访问此方法可能会创建多个对象
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}

public class SingletonTest2 {
    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();
        System.out.println(o1 == o2);
    }
}
