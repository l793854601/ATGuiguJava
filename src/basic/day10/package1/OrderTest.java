package basic.day10.package1;

import basic.day10.java.Order;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        //  default属性：仅Order类所在包内的类可访问
//        order.orderDefault = 1;
        order.orderPublic = 2;
        //  private属性：仅Order类内部可以访问，出了Order类外部就不可访问了
//        order.orderPrivate = 3;

        //  default方法：仅Order类所在包内的类可访问
//        order.methodDefault();
        order.methodPublic();
        //  private方法：仅Order类内部可以访问，出了Order类外部就不可访问了
//        order.methodPrivate();
    }
}
