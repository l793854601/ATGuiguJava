package senior.day06.java;

/*
    Collection接口中声明的方法的测试

    要求：向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()方法
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //  contains(Object o)：判断当前集合中是否包含对象o
        //  判断时，会调用obj对象所在类的equals()方法
        System.out.println(coll.contains(123)); //  true
        System.out.println(coll.contains("Tom"));  //  true
        System.out.println(coll.contains(new Person("Jerry", 20))); //  true

        //  containsAll(Collection coll1)：判断coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 456); //  此方法生成的集合为AbstractList，无法添加元素
        coll.containsAll(coll1);    //  true
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //  remove(Object o)：从当前集合中移除对象o，移除成功返回true，否则返回false
        System.out.println(coll.remove(1234));
        System.out.println(coll);
        System.out.println(coll.remove(new Person("Jerry", 20)));
        System.out.println(coll);

        //  removeAll(Collection coll1)：从当前集合中移除coll1中的所有元素，如果当前集合元素发生改变了（元素被删除了），则返回true，否则返回false
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //  retainAll(Collection coll1)：获取当前集合和coll1集合的交集，并返回给当前集合，如果当前集合元素发生改变则返回true，否则返回false
        Collection coll1 = Arrays.asList(123, 456, 789);
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll);

        //  equals(Object obj)：如果想返回true，则需要当前集合和形参集合都相同
        //  ArrayList不仅要求集合内容相同，还要求元素的顺序相同
        System.out.println(coll.equals(Arrays.asList(123, 456)));   //  true
        System.out.println(coll.equals(Arrays.asList(456, 123)));   //  false
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //  hashCode()：返回当前集合的hash值
        System.out.println(coll.hashCode());

        //  toArray()：将当前集合转换为数组
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));

        //  Arrays.asList(T... a)：将数组转换为集合
        List<String> list = Arrays.asList(new String[] {"AA", "BB", "CC"});
        System.out.println(list);

        List list1 = Arrays.asList(new int[] {123, 456});
        System.out.println(list1);  //  [[I@6956de9]

        List list2 = Arrays.asList(new Integer[] {123, 456});
        System.out.println(list2);  //  [123, 456]
    }
}
