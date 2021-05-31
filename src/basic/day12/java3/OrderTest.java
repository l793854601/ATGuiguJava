package basic.day12.java3;

import basic.day12.java2.Order;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderPublic = 1;
        order.methodPublic();

        //  不同包下的普通类（非子类），要使用Order类，不可以声明为private、缺省、protected权限的属性、方法
//        order.orderPrivate = 2;
//        order.orderDefault = 3;
//        order.orderProtected = 4;
//        order.methodPrivate();
//        order.methodDefault();
//        order.methodProtected();
    }
}
