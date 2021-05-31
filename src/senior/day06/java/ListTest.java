package senior.day06.java;

/*
    1.List接口框架：
        |----Collection接口：单列集合，用来存储一个一个的对象
            |----List接口：有序、有重复的数据   --->"动态数组"（相对于数组的长度固定），替换原有的数组
                |----ArrayList：作为List接口的主要实现类：线程不安全，效率高，底层结构为Object[] elementData存储
                |----LinkedList：底层使用双向链表存储，对于频繁的插入、删除操作，使用此类效率比ArrayList高
                |----Vector：作为List接口的古老实现类：线程安全，效率低，底层结构为Object[] elementData存储

    2.ArrayList源码分析：
        ArrayList源码分析：jdk7、jdk8稍有不同
        jdk7的情况下：
        arrayList list = new ArrayList();   //  底层创建了一个长度为10的Object[] elementData数组
        list.add(123);  //  elementData[0] = 123;
        ...
        list.add(11);   //  如果此次添加导致底层elementData数组容量不够，则扩容
                            默认情况下扩容为原来容量的1.5倍（oldCapacity + (oldCapacity >> 1)），同事需要将原有数组中的数据复制到新的数组中。

        结论：建议开发中使用带参的构造器：public ArrayList(int initialCapacity);

        jdk8的情况下：
        ArrayList list = new ArrayList();   //  底层Object[] elementData数组被初始化为{}，并没有创建长度为10的数组
        list.add(123);  //  第一次调用add()方法时，底层才创建了长度为10的数组，并将123添加到elementData[0]
        ...
        后续的添加和扩容操作与jdk7无异

        小结：jdk7中的ArrayList的对象的创建，类似于单例模式中的饿汉式
             jdk8中的ArrayList的对象的创建，类似于单例模式中的懒汉式，延迟了数组的创建，节省内存

    3.LinkedList源码分析：
        LinkedList list = new LinkedList(); //  LinkedList内部声明了Node类型的first、last属性，默认值为null
        list.add(123);  //  将123封装在Node中，创建了Node对象，将此Node对象赋值给first属性

        //  Node的结构定义如下：体现了LinkedList底层为双向链表的说法
        private static class Node<E> {
            E item; //  实际存储的元素
            Node<E> next;   //  下一个元素
            Node<E> prev;   //  上一个元素

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }

    4.Vector源码分析：jdk7、jdk8中通过public Vector()构造器创建对象时，底层都创建了长度为10的数组
                      在扩容方面，默认扩容为原来的数组长度的2倍

    面试题：ArrayList、LinkedList、Vector的异同？
    同：三个类都实现了List接口，存储数据的特点相同（有序的，可重复的）
    不同：见上
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    /*
        List常用方法1
     */
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);

        //  void add(int index, Object ele)：在index位置插入ele元素
        list.add(1, "BB");
        System.out.println(list);

        //  boolean addAll(int index, Collection eles)：从index位置开始，将eles中的所有元素添加进来
        list.addAll(1, Arrays.asList(1, 2, 3));
        System.out.println(list);

        //  Object get(int index)：获取指定index位置的元素
        System.out.println(list.get(1));
    }

    /*
        List常用方法2
    */
    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        //  int indexOf(Object obj)：返回obj在集合中首次出现的位置，如果不存在，则返回-1
        System.out.println(list.indexOf(456));
        System.out.println(list.indexOf(22222));

        //  int lastIndexOf(Object obj)：返回obj在集合中末次出现的位置，如果不存在，则返回-1
        System.out.println(list.lastIndexOf(456));
        System.out.println(list.lastIndexOf(4567));

        //  Object remove(int index)：移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(0));

        //  Object set(int index, Object ele)：设置指定index位置的元素为ele，并返回原index位置的元素
        System.out.println(list.set(1, "CC"));
        System.out.println(list);

        //  List subList(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置的子集合[fromIndex, toIndex)
        List subList = list.subList(2, list.size());
        System.out.println(subList);
    }

    /*
        List遍历方法
    */
    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //  方式1：Iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("========");

        //  方式2：增强for循环
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("========");

        //  方式3：普通for循环
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            System.out.println(object);
        }
        System.out.println("========");

        //  补充方式4：forEach
        list.forEach(obj -> {
            System.out.println(obj);
        });
    }
}
