package senior.day08.java;

import org.junit.Test;

import java.util.List;

/*
    如何自定义泛型结构：泛型类、泛型接口、泛型方法
    1.关于自定义泛型类、泛型接口：
 */
public class GenericTest1 {

    @Test
    public void test1() {
        //  如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //  要求：如果定义了类是带泛型的，建议在实例化是要指明类的泛型
//        Order order = new Order();
//        order.setOrderT(123);
//        order.setOrderT("ABC");

        Order<String> order1 = new Order<>("OrderAA", 1001, "order:AA");
        System.out.println(order1.getOrderT());
    }

    @Test
    public void test2() {
        //  由于子类在继承带泛型的父类时，指明了泛型类型为Integer，则实例化子类对象时，不在需要指明泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);

        //  由于子类在继承带泛型的父类时，未指明了泛型类型，则子类仍然为泛型类
        SubOrder1<Integer> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT(123);
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        s1 = s2;

        //  泛型不同的引用，不能相互赋值
//        ArrayList<String> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list1 = list2;
    }

    @Test
    public void test4() {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        //  泛型方法在调用时，指明了泛型参数的类型
        List<Integer> list = SubOrder.copyFromArrayToList(array);
        System.out.println(list);
    }
}
