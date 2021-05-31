package senior.day07.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Collections：操作Collection、Map的工具类

    面试题：Collection和Collections的区别
 */
public class CollectionsTest {

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

        //  reverse(List list)：将list反转
        Collections.reverse(list);
        System.out.println(list);

        //  shuffle(List list)：将list内元素随机化处理
        Collections.shuffle(list);
        System.out.println(list);

        //  sort(List list)：将list内部元素自然排序
        Collections.sort(list);
        System.out.println(list);

        //  sort(List list, Comparator c)：将list内部元素定制排序
        Collections.sort(list, (n1, n2) -> Integer.compare((Integer) n2, (Integer) n1));
        System.out.println(list);

        //  swap(List list, int i, int j)：将list内索引为i和j的元素交换
        Collections.swap(list, 0, 1);
        System.out.println(list);

        //  frequency(List list, Object o)：返回list内的元素o出现的次数
        int frequency = Collections.frequency(list, 765);
        System.out.println(frequency);

        //  copy(List dest, List src)：将src复制到dest中
        //  要求dest内元素的长度与src中元素的长度一样，否则会抛出异常：IndexOutOfBoundsException
//        List dest = new ArrayList();  //  错误的写法
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        //  replaceAll(List list, Object oldVal, Object newVal)：将list中的所有oldVal都替换为newVal
        Collections.replaceAll(list, 765, 567);
        System.out.println(list);
    }

    /*
        Collections类中提供了多个synchronizedXxx()方法
        该方法可以将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        //  synchronizedList(List list)：将list转为线程安全的List并返回（原list不变）
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1.getClass());
    }
}
