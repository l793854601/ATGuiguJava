package senior.day12.java3;

import org.junit.Test;
import senior.day12.java2.Employee;
import senior.day12.java2.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    1.Stream关注的是对数据的计算，与CPU打交道
      Collection关注的是对数据的存储，与内存打交道

    2.Stream特点：
    1）Stream自己不会存储元素
    2）Stream不会改变源对象，相反，它们会返回一个持有结果的新Stream
    3）Stream操作是延迟执行的，这意味着它们会等到需要结果的时候才执行

    3.Stream执行流程：
    1）Stream实例化
    2）一系列的中间操作（filter、map）
    3）终止操作

    4.说明：
    1）一个中间操作链，对数据源的数据进行处理
    2）一旦执行终止操作，就执行中间操作链，并产生结果。之后不会再被使用

 */
public class StreamAPITest {

    /*
        创建Stream方式1：通过集合
        default Stream stream()：返回一个顺序流
        default Stream parallelStream()：返回一个并行流
     */
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        Stream<Employee> stream = employees.stream();
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    /*
        创建Stream方式2：通过数组
        static <T> Stream<T> stream(T[] array)：返回一个流
     */
    @Test
    public void test2() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = new Employee[] {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    /*
        创建Stream方式3：通过Stream的of()方法
     */
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    /*
        创建Stream方式4：创建无限流
        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)：迭代
        public static<T> Stream<T> generate(Supplier<T> s)：生成
     */
    @Test
    public void test4() {
        //  遍历前10个偶数
        Stream.iterate(0, num -> num + 2)
                .limit(10)
                .forEach(System.out::println);

        //  随机生成10个数
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
}
