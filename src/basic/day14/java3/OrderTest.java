package basic.day14.java3;

/*
    对属性赋值的位置：
    1）默认初始化
    2）显式初始化/5）在代码块中赋值
    3）构造器初始化
    4）对象创建后，通过"对象.属性"或"对象.方法"的方式，进行赋值


    顺序：1 -> 2 / 5 -> 3 -> 4
 */

class Order {
    {
        orderId = 4;
    }

    int orderId = 3;
}

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.orderId);
    }
}
