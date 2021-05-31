package senior.day06.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
    TreeSet的使用：
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式：自然排序（实现Comparable接口）和定制排序（Comparator接口）
    3.自然排序中，比较两个对象是否相同的标准为：compareTo()方法是否为0，不再根据equals()方法
    4.定制排序中，比较两个对象是否相同的标准为：compare()方法是否为0，不再根据equals()方法
    TreeSet底层结构：二叉树（准确的说，是红黑树）
 */

public class TreeSetTest {
    @Test
    public void test1() {
        Set set = new TreeSet();

        //  不能添加不同类型的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom", 12));

        //  举例1
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //  举例2
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {

        Comparator<User> comparator = (u1, u2) -> {
            return Integer.compare(u1.getAge(), u2.getAge());
        };

        Set set = new TreeSet(comparator);
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Marry", 33));
        set.add(new User("Jack", 33));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
