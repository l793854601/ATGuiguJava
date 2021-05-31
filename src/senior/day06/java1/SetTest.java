package senior.day06.java1;

/*
    Set接口的框架结构：
    |----Collection接口：单列集合，用来存储一个一个的对象
            |----Set接口：无序、不可重复的数据   --->高中讲的"集合"：无序性、确定性、互异性
                |----HashSet：作为Set接口的主要实现类，线程不安全的，可以存储null值
                    |----LinkedHashSet：HashSet的子类，通过双向链表，可以实现遍历顺序跟元素添加顺序一致
                                        对于频繁的便利操作，LinkedHashSet效率高于HashSet
                |----TreeSet：底层实现为二叉树（红黑树），可以按照添加对象指定属性进行排序

    1.Set接口中没有额外定义新的方法，使用的都是Collection接口中的方法

    2.要求：向Set中添加的数据，其所在的类一定要重写hashCode方法()和equals()方法
            equals()相同的两个对象，其hashCode()一定相同
      重写hashCode方法()和equals()方法的小技巧：对象中用作equals()方法比较的field，都应该用来计算hashCode()
      建议自动生成hashCode()方法与equals()方法
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

    /*
        一、Set：存储无序的、不可重复的数据
        以HashSet为例：
        1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加。
                  而是根据数据的哈希值（hashCode()）决定的。

        2.不可重复性：保证添加的元素按照equals()方法判断时，不能为true（元素是否相同，是根据equals()方法判断的）

        二、添加元素的过程
        以HashSet为例：
        我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
        此哈希值接着通过某种算法，在HashSet底层数组中的存放位置（即为：索引位置），
        判断数组此位置上是否有元素：
            如果此位置上没有其他元素，则元素a添加成功     --->情况1
            如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的哈希值：
                如果哈希值不相同，则元素a添加成功     --->情况2
                如果哈希值相同，进而需要调用元素a所在类的equals()方法：
                    如果equals()方法返回true，则元素a添加失败
                    如果equals()方法返回false，则元素a添加成功     --->情况3

        对于添加成功情况2、情况3而言：元素a与已经存在指定索引位置上的数据以链表的方式存储。
        jdk7：元素a放在数组中，指向原来的元素
        jdk8：原来的元素在数组中，指向元素a

        HashSet底层：数组+链表的结构
     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add(123);
        set.add("CC");
        set.add("AA");
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
        LinkedHashSet的使用：
        LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个数据和后一个数据
        优点：对于频繁的便利操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add(123);
        set.add("CC");
        set.add("AA");
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
