package basic.day13.java1;

/*
    面试题：== 和equals()的区别

    一、回复 == 的使用：
    == 是一个运算符
    1.可以使用在基本类型数据变量和引用数据类型变量中
    2.如果比较的是基本类型数据变量，则比较的是两个变量保存的数据是否相等（不一定类型相同）
    3.如果比较的是引用数据类型变量，则比较的是两个对象的地址值是否相同（即两个引用是否指向同一个堆空间中给的对象实体）

    补充：== 符号，在使用时，必须保证符号左右两边的变量类型一致（相同，或者可以其中一个的类型可以提升为另一个的类型）

    二、equals方法的使用：
    1.equals是一个方法，而非运算符

    2.equals方法只能适用于引用数据类型

    3.Object类中equals方法的定义：
        public boolean equals(Object obj) {
            return (this == obj);
        }
        说明：Object类中定义的equals方法与 == 作用是相同给的

    4.String、Date、File、包装类等，都重写了Object类中的equals方法，
      重写之后，比较的不是两个引用的地址是否相同，而是比较两个对象的"内容"是否相同

    5.通常情况下，我们自定义的类如果使用equals方法的话，也通常是比较两个对象的"内容"是否相同。
      则需要重写equals方法
      重写的原则：比较两个对象的"内容"是否相同。
 */

import java.util.Date;

public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        System.out.println(i == j); //  true

        double d = 10.0;
        System.out.println(i == d);//   true

        char c = 10;
        System.out.println(i == c); //  true

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);// true

        Customer customer1 = new Customer("Tom", 21);
        Customer customer2 = new Customer("Tom", 21);
        System.out.println(customer1 == customer2); //  false

        String string1 = new String("ITGuigu");
        String string2 = new String("ITGuigu");
        System.out.println(string1 == string2); //  false

        System.out.println("*******************************");

        //  Object类中equals方法实现为return (this == obj);
        System.out.println(customer1.equals(customer2));    //  没有重写equals方法的情况下，为false
        System.out.println(string1.equals(string2));    //  true

        Date date1 = new Date(324323234332L);
        Date date2 = new Date(324323234332L);
        System.out.println(date1.equals(date2));    //  true
    }
}
