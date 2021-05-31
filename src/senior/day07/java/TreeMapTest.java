package senior.day07.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

/*
    向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    因为要按照key进行排序
    自然排序、定制排序
 */
public class TreeMapTest {

    /*
        自然排序
     */
    @Test
    public void test1() {
        TreeMap map = new TreeMap();
        map.put(new User("Tom", 23), 98);
        map.put(new User("Jerry", 32), 89);
        map.put(new User("Jack", 20), 76);
        map.put(new User("Rose", 18), 100);

        map.forEach((k, v) -> {
            System.out.println("key: " + k + ", value: "+ v);
        });
    }

    /*
        定制排序
     */
    @Test
    public void test2() {
        Comparator<User> comparator = (u1, u2) -> {
            return Integer.compare(u1.getAge(), u2.getAge());
        };

        TreeMap map = new TreeMap(comparator);
        map.put(new User("Tom", 23), 98);
        map.put(new User("Jerry", 32), 89);
        map.put(new User("Jack", 20), 76);
        map.put(new User("Rose", 18), 100);

        map.forEach((k, v) -> {
            System.out.println("key: " + k + ", value: "+ v);
        });
    }
}
