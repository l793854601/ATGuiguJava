package basic.day13.exer2;

/*
    编写Order类：
    有int型的orderId、String型的orderName
    相应的getter、setter方法
    两个参数的构造器
    重写父类的equals方法，并判断测试类中创建的两个对象是否相等

 */

class Order {
    private int orderId;
    private String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Order) {
            Order order = (Order) o;
            return orderId == order.orderId && orderName.equals(order.orderName);
        }
        return false;
    }
}

public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order(1000, "Order1");
        Order o2 = new Order(1001, "Order2");
        Order o3 = new Order(1000, "Order1");
        Order o4 = o2;

        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
        System.out.println(o2.equals(o4));
    }
}
