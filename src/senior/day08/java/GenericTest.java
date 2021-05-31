package senior.day08.java;

import org.junit.Test;

import java.util.*;

/*
    泛型的使用
    1.jdk5.0新增的特性

    2.在集合中使用泛型：
        1）集合接口/类在jdk5.0时，都修改为带泛型的接口
        2）在实例化集合类的对象时，可以指明具体的泛型类型
        3）指明了泛型类型后，在集合类/接口中，凡是定义类或接口时，内部结构（方法、构造器、属性等）使用到的类的泛型的位置，都指定为实例化时的泛型类型
        4）泛型的类型必须是类，不能是基本数据类型，如果需要用到基本数据类型，则使用对应的包装类
        5）如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object

    3.如何自定义泛型结构：泛型类、泛型接口、泛型方法
 */
public class GenericTest {

    /*
        在集合中不使用泛型的情况
     */
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        //  需求：存放学生成绩（整型，Integer）
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //  问题1：在编译时没有类型检查（类型不安全）
        list.add("Tom");

        for (Object o : list) {
            //  问题2：强转时，如果类型不匹配，则会抛出异常：ClassCastException
            int score = (Integer) o;
            System.out.println(score);
        }
    }


    /*
        在集合中使用泛型的情况：以ArrayList为例
     */
    @Test
    public void test2() {
//        ArrayList<Integer> list = new ArrayList<Integer>();
        //  jdk7新特性：类型推断
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //  编译时会进行类型检查，保证数据安全
//        list.add("ABC");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            //  避免了强转操作，进而规避了类型转换异常
            int score = iterator.next();
            System.out.println(score);
        }
    }

    /*
        在集合中使用泛型的情况：以HashMap为例
     */
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);
//        map.put(123, "ABC");

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.forEach(entry -> {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key: " + key + ", value: " + value);
        });
    }
}
