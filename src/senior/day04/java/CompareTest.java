package senior.day04.java;

/*
    1.说明：Java中的对象，正常情况下，只能进行比较： ==、!=，不能使用>、<比较
            但是在开发场景中，我们需要对多个对象进行排序，言外之意，需要比较比较对象的大小
            如何实现？使用两个接口中的任何一个：Comparable或Comparator

    2.Comparable接口与Comparator接口的使用：
        Comparable接口一旦指定，保证Comparable接口实现类的对象在任何位置都可以比较大小
        Comparator接口属于临时性的比较
 */

import org.junit.Test;

import java.util.Arrays;

public class CompareTest {
    /*
        Comparable使用举例：自然排序
        1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式
        2.像String、包装类重写了compareTo()方法以后，进行了从小到大的排列
        3.重写compareTo(obj)的规则：
            如果当前对象this大于形参对象obj，则返回正整数
            如果当前对象this小于形参对象obj，则返回负整数
            如果当前对象this等于形参对象obj，则返回零
        4.对于自定义类，如果需要排序，则需要让自定义类实现Comparable接口，并重写compareTo()方法
          在compareTo()方法指明如何排序
     */
    @Test
    public void test1() {
        String[] arr = new String[] {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        自定义对象排序
     */
    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("Lenovo mouse", 34);
        arr[1] = new Goods("Dell mouse", 43);
        arr[2] = new Goods("Xiaomi mouse", 12);
        arr[3] = new Goods("Huawei mouse", 65);
        arr[4] = new Goods("HP mouse", 65);
        //  自然排序（根据自身compareTo()方法内部的实现来排序）
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        Comparator接口的使用：
        1.背景:
        当元素的类型没有实现Comparable接口，而又不方便修改代码
        或者实现了Comparable接口的排序规则不适合当前的操作，那么可以考虑使用Comparator接口来排序
        2.重写compare(Object o1, Object o2)方法，比较o1与o2的大小：
            如果返回正整数，则表示o1大于o2
            如果返回负整数，则表示o1小于o2
            如果则返回零，则表示o1等于o2
     */
    @Test
    public void test3() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("Lenovo mouse", 34);
        arr[1] = new Goods("Dell mouse", 43);
        arr[2] = new Goods("Xiaomi mouse", 12);
        arr[3] = new Goods("Huawei mouse", 65);
        arr[4] = new Goods("HP mouse", 65);

        //  自定义排序（按照商品价格从高到低排序）
        Arrays.sort(arr, (g1, g2) -> {
            return -Double.compare(g1.getPrice(), g2.getPrice());
        });
        System.out.println(Arrays.toString(arr));
    }
}
