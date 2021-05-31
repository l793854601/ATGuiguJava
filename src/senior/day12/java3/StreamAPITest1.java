package senior.day12.java3;

import org.junit.Test;
import senior.day12.java2.Employee;
import senior.day12.java2.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    测试Stream的中间操作
 */
public class StreamAPITest1 {

    /*
        1.筛选与切片：
        filter(Predicate p)：从流中排除某些元素
        limit(n)：截断流，使其元素不超过给定数量
        skip(n)：跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
        distinct()：筛选，通过流所生成的hashCode()和equals()去除重复元素
     */
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //  遍历list中工资大于7000的Employee对象
        list.stream()
                .filter(e -> e.getSalary() > 7000)
                .forEach(System.out::println);
        System.out.println();

        //  遍历list中前3个Employee对象
        list.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println();

        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));

        //  除去list中重复的Employee对象，并遍历list
        list.stream()
                .distinct()
                .forEach(System.out::println);
    }

    /*
        2.映射：
        map(Function f)：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        flatMap(Function f)：接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有的流连接成一个流
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();

        //  过滤出List中姓名长度大于3的Employee，并遍历输出Employee的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream()
                .map(Employee::getName)
                .filter(s -> s.length() > 3)
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .map(StreamAPITest1::fromStringToStream)
                .forEach(stream -> {
                    //  map之后，返回的是Stream，因此需要再调用forEach遍历数据
                    stream.forEach(System.out::println);
                });
        System.out.println();

        list.stream()
                .flatMap(StreamAPITest1::fromStringToStream)
                .forEach(System.out::println);
    }

    /*
        将字符串中的多个字符构成的集合转换为对应的Stream实例
     */
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        //  对比map
//        list1.add(list2);
        //  对比flatMap
        list1.addAll(list2);
        System.out.println(list1);
    }

    /*
        3.排序：
        sorted()：产生一个新流，其中按自然顺序排序（需要元素实现Comparable接口）
        sorted(Comparator com)：产生一个新流，按照定制顺序（比较器顺序）排序
     */
    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);

        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        List<Employee> employees = EmployeeData.getEmployees();

        //  根据Employee的年龄，对employees进行排序
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out::println);
    }
}
