package senior.day12.java3;

import org.junit.Test;
import senior.day12.java2.Employee;
import senior.day12.java2.EmployeeData;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Stream的终止操作
 */
public class StreamAPITest2 {

    /*
        1.匹配与查找：
        allMatch(Predicate p)：检查是否匹配所有元素
        anyMatch(Predicate p)：检查是否至少匹配一个元素
        noneMatch(Predicate p)：检查是否没有匹配所有元素
        findFirst()：返回第一个元素
        findAny()：返回当前流中的任意元素
        count()：返回流中元素总数
        max(Comparator c)：返回流中最大值
        min(Comparator c)：返回流中最小值
        forEach(Consumer c)：内部迭代（区别于Collection接口的外部迭代）
     */
    @Test
    public void test1() {
        //  判断employees中是否年龄都大于18岁
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream()
                .allMatch(employee -> employee.getAge() > 18);
        System.out.println(allMatch);
        System.out.println();

        //  判断employees中是否至少有一个薪资大于10000
        boolean anyMatch = employees.stream()
                .allMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch);
        System.out.println();

        //  判断employees中是否都不姓雷
        boolean noneMatch = employees.stream()
                .noneMatch(employee -> employee.getName().contains("雷"));
        System.out.println(noneMatch);
        System.out.println();

        //  返回employees中第一个员工（可能为空，因此会返回Optional类型的元素）
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println();

        //  返回employees中任意员工（可能为空，因此会返回Optional类型的元素）
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
        System.out.println();

        //  返回employees员工工资大于5000的个数
        long count = employees.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .count();
        System.out.println(count);
        System.out.println();

        //  返回employees中工资最高的员工的工资
        Optional<Double> max = employees.stream()
                .map(Employee::getSalary)
                .max(Double::compare);
        System.out.println(max);
        System.out.println();

        //  返回Employees中工资最低的员工
        Optional<Employee> min = employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println();

        //  Collection自带的forEach遍历
        employees.forEach(System.out::println);
        System.out.println();

        //  遍历Employees
        employees.stream()
                .forEach(System.out::println);
    }

    /*
        2.归约：
        1.reduce(T identity, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值，返回T
        2.reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值，返回Optional<T>
     */
    @Test
    public void test2() {
        //  计算1-10内自然数的和
        Integer reduce = Stream.iterate(1, n -> n + 1)
                .limit(10)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        //  计算employees所有员工工资的总和
        Optional<Double> reduce1 = EmployeeData.getEmployees()
                .stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce1);
    }

    /*
        3.收集：
        collect(Collector c)：将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test3() {
        //  将employees中工资大于6000的员工筛选出来，并重新放入List中
        List<Employee> list = EmployeeData.getEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > 6000)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println();

        //  将employees中年龄大于12的员工筛选出来，并重新放入Set中
        Set<Employee> set = EmployeeData.getEmployees()
                .stream()
                .filter(employee -> employee.getAge() > 12)
                .collect(Collectors.toSet());
        System.out.println(set);
    }
}
