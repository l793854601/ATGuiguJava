package senior.day12.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
    方法引用的使用：
    1.使用情景：当要传递给Lambda表达体的操作，已经有实现的方法了，可以使用方法引用。

    2.方法引用：本质就是lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用也是函数式接口的实例。

    3.使用格式：类（或对象）::方法

    4.三种情况：
        情况1）对象::实例方法
        情况2）类::静态方法
        情况3）类::实例方法

    5.方法引用使用的要求：接口中的抽象方法，其形参列表跟返回值类型，和方法引用的方法的形参列表跟返回值类型相同（针对于情况1、情况2）。
 */
public class MethodTest {

    /*
        情况1：对象::实例方法
        Consumer中的void accept(T t)
        PrintStream中的void println(T t)
     */
    @Test
    public void test1() {
        Consumer<String> c1 = s -> System.out.println(s);
        c1.accept("北京");

        Consumer<String> c2 = System.out::println;
        c2.accept("南京");
    }

    /*
        Supplier中的T get()
        Employee中的String getName()
     */
    @Test
    public void test2() {
        Employee e1 = new Employee(1001, "Tom", 23, 5600);
        Supplier<String> s1 = () -> e1.getName();
        String str1 = s1.get();
        System.out.println(str1);

        Supplier<String> s2 = e1::getName;
        String str2 = s2.get();
        System.out.println(str2);
    }

    /*
        情况3：类::静态方法
        Comparator中的int compare(T t1, T t2)
        Integer中的int compare(int x, int y)
     */
    @Test
    public void test3() {
        Comparator<Integer> c1 = (i1, i2) -> Integer.compare(i1, i2);
        int r1 = c1.compare(100, 10);
        System.out.println(r1);

        Comparator<Integer> c2 = Integer::compare;
        int r2 = c2.compare(100, 10);
        System.out.println(r2);
    }

    /*
        Function中的R apply(T t)
        Math中的Long round(Double d)
     */
    @Test
    public void test4() {
        Function<Double, Long> f1 = t -> Math.round(t);
        long l1 = f1.apply(100.4);
        System.out.println(l1);

        Function<Double, Long> f2 = Math::round;
        long l2 = f2.apply(99.8);
        System.out.println(l2);
    }

    /*
        情况3：类::实例方法
        Comparator中的int compare(T t1, T t2)
        String中的int compareTo(t2)
     */
    @Test
    public void test5() {
        Comparator<String> c1 = (s1, s2) -> s1.compareTo(s2);
        int r1 = c1.compare("abc", "abcd");
        System.out.println(r1);

        Comparator<String> c2 = String::compareTo;
        int r2 = c2.compare("abc", "abcd");
        System.out.println(r2);
    }

    /*
        BiPredicate中的boolean test(T t, U u)
        String中的boolean equals(String s)
     */
    @Test
    public void test6() {
        BiPredicate<String, String> b1 = (s1, s2) -> s1.equals(s2);
        boolean r1 = b1.test("a", "a");
        System.out.println(r1);

        BiPredicate<String, String> b2 = String::equals;
        boolean r2 = b2.test("a", "a");
        System.out.println(r2);
    }

    /*
        Function中的R apply(T t)
        Employee中的String getName()
     */
    @Test
    public void test7() {
        Employee e1 = new Employee(1001, "Tom", 23, 5600);
        Function<Employee, String> f1 = e -> e.getName();
        String s1 = f1.apply(e1);
        System.out.println(s1);

        Function<Employee, String> f2 = Employee::getName;
        String s2 = f2.apply(e1);
        System.out.println(s2);
    }
}
