package senior.day12.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
    1.构造器引用：
        与方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
        抽象方法的返回值类型即为构造器所属的类的类型

    2.数组引用：
        可以把数组看做是一个特殊的类，则写法与构造器引用一致
 */
public class ConstructorRefTest {

    /*
        构造器引用
        Supplier中的T get()
        Employee中给的空参构造器Employee()
     */
    @Test
    public void test1() {
        Supplier<Employee> s1 = () -> new Employee();
        Employee e1 = s1.get();
        System.out.println(e1);

        Supplier<Employee> s2 = Employee::new;
        Employee e2 = s2.get();
        System.out.println(e2);
    }

    /*
        Function中的R apply(T t)
        Employee中的带参构造器Employee(int id)
     */
    @Test
    public void test2() {
        Function<Integer, Employee> f1 = id -> new Employee(id);
        Employee e1 = f1.apply(1001);
        System.out.println(e1);

        Function<Integer, Employee> f2 = Employee::new;
        Employee e2 = f2.apply(1002);
        System.out.println(e2);
    }

    /*
        BiFunction中的R apply(T t, U u)
        Employee中的带参构造器Employee(int id, String name)
     */
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> f1 = (id, name) -> new Employee(id, name);
        Employee e1 = f1.apply(1001, "Tom");
        System.out.println(e1);

        BiFunction<Integer, String, Employee> f2 = Employee::new;
        Employee e2 = f2.apply(1002, "Jerry");
        System.out.println(e2);
    }

    /*
        数组引用
        Function中的R apply(T t)
     */
    @Test
    public void test4() {
        Function<Integer, String[]> f1 = length -> new String[length];
        String[] s1 = f1.apply(5);
        System.out.println(Arrays.toString(s1));

        Function<Integer, String[]> f2 = String[]::new;
        String[] s2 = f2.apply(5);
        System.out.println(Arrays.toString(s2));
    }
}
