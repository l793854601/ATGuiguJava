package senior.day05.java2;

/*
    一.集合框架的概述

    1.集合、数组，都是对多个数据进行存储操作的结构，简称Java容器
      说明：此时的"存储"，主要指的是内存层面的存储，不涉及到持久化的存储

    2.1 数组在存储多个数据方面的特点：
        > 数组一旦初始化完毕，长度就确定了
        > 数组一旦定义，其元素的类型就确定了。我们也就只能操作指定类型的数据了。
    2.2 数组在存储多个数据方面的缺点：
        > 一旦初始化，其长度就不可修改
        > 数组中提供的方法非常有限，对于添加、删除、插入数据登操作，非常不便
        > 获取数组中实际元素的个数，数组没有现成的方法或属性可用
        > 数组存储数据的特点：有序、可重复，对于无序、不重复的需求，数组无法满足

    二.集合框架
        |----Collection接口：单列集合，用来存储一个一个的对象
            |----List接口：有序、有重复的数据   --->"动态数组"（相对于数组的长度固定）
                |----ArrayList、LinkedList、Vector
            |----Set接口：无序、不可重复的数据   --->高中讲的"集合"：无序性、确定性、互异性
                |----HashSet、LinkedHashSet、TreeSet
        |----Map接口：双列集合，用来存储一对一对（key-value）的数据  --->高中讲的"函数"：y = f(x)
            |----HashMap、LinkedHashMap、TreeMap、HashTable、Properties

    三.Collection接口中的方法的使用

 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        //  addObject(Object e)：将元素e添加到当前的集合中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        //  size()：获取添加的元素的个数
        System.out.println(coll.size());

        //  addAll(Collection coll1)：将coll1集合中的所有元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll);

        //  clear()：清空集合元素
        coll.clear();

        //  isEmpty()：判断当前集合是否为空（size是否为0）
        System.out.println(coll.isEmpty());
    }
}
