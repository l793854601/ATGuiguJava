package senior.day07.exer1;


/*
    创建该类的5个对象，并把这些对象放入TreeSet集合中，分别以下面两种方式进行排序，并遍历输出
    1.使Employee实现Comparable接口，并按name排序
    2.创建TreeSet时传入Comparator对象，按生日日期的先后排序
 */

import org.junit.Test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {

    /*
        问题1，使用自然排序
     */
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
        问题2，使用定制排序
     */
    @Test
    public void test2() {
        Comparator<Employee> comparator = (e1, e2) -> {
            MyDate d1 = e1.getBirthday();
            MyDate d2 = e2.getBirthday();
            return d1.compareTo(d2);
        };

        TreeSet<Employee> set = new TreeSet<>(comparator);
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
