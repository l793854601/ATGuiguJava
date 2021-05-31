package basic.day10.java;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderDefault = 1;
        order.orderPublic = 2;
        //  private属性：仅Order类内部可以访问，出了Order类外部就不可访问了
//        order.orderPrivate = 3;

        order.methodDefault();
        order.methodPublic();
        //  private方法：仅Order类内部可以访问，出了Order类外部就不可访问了
//        order.methodPrivate();
    }
}
