package senior.day06.java;

/*
    集合元素的遍历，使用迭代器Iterator接口
    1.内部的方法：hasNext()、next()
    2.几个对象每次调用iterator()方法，都会得到一个全新的迭代器对象。默认游标都是在集合的第一个元素之前
    3.内部定义了remove()方法，可以在遍历集合时，删除集合的元素。此方法不同于集合直接调用remove()方法
    4.使用iterator()遍历集合时，不要增加、删除集合内的元素，否则会抛出异常java.util.ConcurrentModificationException
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //  方式1：不推荐
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //  java.util.NoSuchElementException
//        System.out.println(iterator.next());

        //  方式2：不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        
        //  方式3：推荐
        while (iterator.hasNext()) {
            /*
                next()执行流程：
                1.将游标下移
                2.将下移以后几个位置上的元素返回
             */
            System.out.println(iterator.next());
        }
    }

    /*
        以下写法为错误写法
        使用next()返回的对象是否为null的方式判断并不准确
        因为你无法确定实现类的next()在没有元素时是怎么处理的（大部分情况下，都是抛出异常）
        必须结合hasNext()一起使用
     */
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        Object e = null;
        while ((e = iterator.next()) != null){
            System.out.println(e);
        }
    }

    /*
        测试Iterator中remove()方法
        注意：1.如果还未调用next()方法，或在上一次调用next()方法之后已经调用了remove()方法，再调用remove()方法，则会抛出异常IllegalStateException
     */
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if ("Tom".equals(o)) {
                //  删除集合中的"Tom"
                iterator.remove();
            }
        }

        System.out.println(coll);
    }
}
