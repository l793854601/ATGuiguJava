package senior.day07.java;

/*
    一、Map的实现类的结构：
        |----Map接口：双列集合，用来存储一对一对（key-value）的数据  --->高中讲的"函数"：y = f(x)
            |----HashMap：作为Map接口的主要实现类，线程不安全的，效率高，可以存储null的key、value
                 |----LinkedHashMap：保证在遍历Map时，可以按照添加的顺序实现遍历
                                     在原有的HashMap底层结构基础上，添加了一对引用，指向当前元素的前一个、后一个元素
                                     对于频繁的遍历操作，LinkedHashMap的执行效率高于HashMap
            |----TreeMap：保证按照添加的key、value进行排序，实现排序遍历，此时考虑key的自然排序或定制排序
                          底层使用红黑树
            |----HashTable：作为Map接口的古老实现类，线程安全的，效率低，不能存储null的key、value
                |----Properties：常用来处理配置文件。key、value都是String类型

    HashMap底层：数组+链表（jdk7及之前）
                 数组+链表+红黑树（jdk8）

    面试题：
    1.HashMap底层实现原理
    2.HashMap和Hashtable的异同
    3.ConcurrentHashMap与Hashtable的异同

    二、Map结构的理解：
        Map中的key：无序的、不可重复的，使用Set存储所有的key    --->要求key所在的类要重写equals()方法和hashCode()方法
        Map中的value：无序的、可重复的，使用Collection存储所有的value  --->要求value所在的类要重写equals()方法
        一个key-value键值对，构成了一个Entry对象
        Map中的Entry：无序的、不可重复的，使用Set存储所有的Entry

    三、HashMap的底层实现原理：
        以jdk7为例：
        //  在实例化以后，底层创建了长度为16的一维数组：Entry[] table
        HashMap map = new HashMap();
        ...可能已经执行过多次put
        //  首先，调用key1所在类的hashCode()方法计算key1的哈希值，此哈希值经过某种算法计算以后，得到Entry数组中的存放位置
        //  如果此位置上的数据为空，此时的key1-value1添加成功  --->情况1
        //  如果位置上的数据不为空，意味着此位置上存在一个或多个数据（以链表形式存在），比较key1与已经存在的一个或多个数据的哈希值
        //      如果key1的哈希值与已经存在的一个或多个数据的哈希值都不相同，此时key1-value1添加成功  --->情况2
        //      如果key1的哈希值与已经存在的某一个数据key2-value2的哈希值相同，继续调用key1所在类的equals()方法进行比较
        //          如果equals()返回false，则key1-value1添加成功  --->情况3
        //          如果equals()返回true，则使用value1替换value2
        map.put(key1, value1);

        补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储

        在不断的添加过程中，会涉及到扩容问题，当超出临界值，且要存放的位置不为空，则扩容。
        默认的扩容方式：扩容为原来的2倍，并将原有的数据复制过来

        jdk8相较于jdk7在底层实现方面的不同：
        1.HashMap map = new HashMap(); 底层没有创建长度为16的一维数组
        2.jdk8底层的数组为Node[]类型，而非Entry[]类型
        3.首次调用put()方法时，底层创建长度为16的Node[]数组
        4.jdk7底层结构只有：数组+链表。jdk8的底层结构：数组+链表+红黑树
          当数组的某一个索引位置上的元素以链表形式存在的数据个数大于8，且当前数组长度超过64，此时此索引位置上的所有数据改为使用红黑树存储

        DEFAULT_INITIAL_CAPACITY：HashMap的默认容量：16
        DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
        threshold：扩容的临界值：容量*加载因子，首次为16 * 0.75 = 12
        TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树
        MIN_TREEIFY_CAPACITY：bucket中的Node转化为红黑树时最小的hash表容量：64

    四、LinkedHashMap的底层实现原理（了解）
        源码中：
        static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;   //  能够记录添加的元素的先后顺序
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }

    五、Map接口中定义的方法：
        添加、删除、修改操作：
        Object put(Object key, Object value)：将指定key-value添加（或修改）当前map对象中，如果是修改，则返回原value，否则返回null
        void putAll(Map m)：将m中的所有key-value对象放到当前map中
        Object remove(Object key)：移除指定key的key-value，并返回value，如果不存在key-value，则返回null
        void clear()：情况当前map中的所有数据

        元素查询的操作：
        Object get(Object key)：获取指定key对应的value
        boolean containsKey(Object key)：判断是否包含指定的key
        boolean containsValue(Object value)：判断是否包含指定的value
        int size()：返回map中key-value对的个数
        boolean isEmpty()：判断当前map是否为空（key-value对的个数是否为0）
        boolean equals(Object obj)：判断当前map和参数对象obj是否相等

        元视图操作的方法：
        Set ketSet()：返回所有key构成的Set集合
        Collection values()：返回所有value构成的Collection集合
        Set entrySet()：返回所有key-value对构成的Set集合
 */

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class MapTest {

    @Test
    public void test1() {
        //  HashMap可以存储null的key、value
        Map map = new HashMap();
        map.put(null, 123);
        map.put(123, null);
        System.out.println(map);

        //  Hashtable不能存储null的key、value
//        map = new Hashtable();
//        map.put(null, 123);
//        map.put(123, null);
    }

    @Test
    public void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");
        map.put("E", "5");
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
    }

    @Test
    public void test3() {
        Map<Integer, String> map = new HashMap<>();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);

        map = new LinkedHashMap<>();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);
    }

    /*
        添加、删除、修改操作：
        Object put(Object key, Object value)：将指定key-value添加（或修改）当前map对象中，如果是修改，则返回原value，否则返回null
        void putAll(Map m)：将m中的所有key-value对象放到当前map中
        Object remove(Object key)：移除指定key的key-value，并返回value，如果不存在key-value，则返回null
        void clear()：情况当前map中的所有数据
     */
    @Test
    public void test4() {
        Map map = new HashMap();
        //  添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //  修改
        map.put("AA", 87);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.putAll(map1);

        System.out.println(map);

        //  Object remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //  void clear()
        map.clear();
        System.out.println(map);
        System.out.println(map.size());
    }

    /*
        元素查询的操作：
        Object get(Object key)：获取指定key对应的value
        boolean containsKey(Object key)：判断是否包含指定的key
        boolean containsValue(Object value)：判断是否包含指定的value
        int size()：返回map中key-value对的个数
        boolean isEmpty()：判断当前map是否为空（key-value对的个数是否为0）
        boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test5() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        //  Object get(Object key)
        System.out.println(map.get(45));
        System.out.println(map.get(455));

        //  boolean containsKey(Object key)
        System.out.println(map.containsKey("BB"));
        System.out.println(map.containsKey("BBB"));

        //  boolean containsValue(Object value)
        System.out.println(map.containsValue(123));
        System.out.println(map.containsValue(1233));

        //  int size()
        System.out.println(map.size());

        //  boolean isEmpty()
        System.out.println(map.isEmpty());

        map.clear();
        System.out.println(map.isEmpty());
    }

    /*
        元视图操作的方法：
        Set ketSet()：返回所有key构成的Set集合
        Collection values()：返回所有value构成的Collection集合
        Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test6() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 56);

        //  遍历所有的key：keySet()
        Set set = map.keySet();
        set.forEach(System.out::println);

        System.out.println("======");

        //  遍历所有的value：values()
        Collection values = map.values();
        values.forEach(System.out::println);

        System.out.println("======");

        //  遍历所有的key-value
        //  方式1
        Set entrySet = map.entrySet();
        entrySet.forEach(entry -> {
            Map.Entry e = (Map.Entry) entry;
            System.out.println("key: " + e.getKey() + ", value: " + e.getValue());
        });

        System.out.println("======");

        //  方式2
        Set ketSet = map.keySet();
        ketSet.forEach(key -> {
            Object value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        });

        System.out.println("======");

        //  方式3（推荐）
        map.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });
    }
}
