package senior.day08.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order<T> {
    String orderName;
    int orderId;
    T orderT;

    public Order() {
        //  编译不通过
//        T[] arr = new T[10];
        //  创建数组，必须指明类型，但泛型在运行阶段会擦除泛型类型，因此只能按照下面的方式实例化泛型数组
        T[] arr = (T[]) new Object[10];

    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //  静态方法中不能使用类的泛型
//    public static void show(T orderT) {
//        System.out.println(orderT);
//    }

    public void show() {
        //  编译不通过
//        try {
//
//        } catch (T e) {
//
//        }
    }

    //  泛型方法：在方法中出现了泛型的结构，泛型的参数跟类的泛型参数没有任何关系
    //  泛型方法所属的类是不是泛型类，都没有关系
    //  泛型方法可以声明为静态的，原因：泛型参数是在调用方法时确定的，并非在实例化对象时确定
    public static <E> List<E> copyFromArrayToList(E[] array) {
        List<E> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }
}
