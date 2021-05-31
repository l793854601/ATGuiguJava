package senior.day12.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/*
    Lambda表达式的使用
    1.举例：(o1, o2) -> Integer.compare(o1, o2);

    2.格式：
        ->：Lambda操作符 或 箭头操作符
        ->左边：Lambda形参列表（其实就是接口中的抽象方法的形参列表）
        ->右边：Lambda体（其实就是重写的抽象方法的方法体）

    3.Lambda表达式的使用：分为6种情况
        总结：
        ->左边：Lambda形参列表的参数类型可以省略（类型推断）
                如果Lambda形参列表只有一个参数，则一对()可以省略
        ->右边：Lambda体应该是用一对{}包裹
                如果Lambda体只有一条执行语句（可能是return语句），则可以省略这一对{}和return关键字

    4.Lambda表达式的本质：作为函数式接口匿名实现类的实例

    5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。
      我们可以在一个接口上使用@FunctionalInterface注解，这样做可以检测该接口是否是一个函数式接口，
      同时javadoc也会包含一条生命，说明这个接口是一个函数式接口
 */
public class LambdaTest1 {

    /*
        语法格式1：无参、无返回值
     */
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        Runnable r2 = () -> {
            System.out.println("我爱北京故宫");
        };
        r2.run();
    }

    /*
        语法格式2：Lambda表达式需要一个参数，但是没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c1.accept("谎言和誓言的区别是什么？");

        Consumer<String> c2 = (String s) -> {
            System.out.println(s);
        };
        c2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    /*
        语法格式3：数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
     */
    @Test
    public void test3() {
        Consumer<String> c1 = (String s) -> {
            System.out.println(s);
        };
        c1.accept("一个是听的人当真了，一个是说的人当真了");

        Consumer<String> c2 = (s) -> {
            System.out.println(s);
        };
        c2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    /*
        语法格式4：Lambda表达式若只需要一个参数，则参数的小括号可以省略
     */
    @Test
    public void test4() {
        Consumer<String> c1 = (s) -> {
            System.out.println(s);
        };
        c1.accept("一个是听的人当真了，一个是说的人当真了");

        Consumer<String> c2 = s -> {
            System.out.println(s);
        };
        c2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    /*
        语法格式5：Lambda表达式需要两个或两个以上的参数，多条语句执行，并且可以有返回值
     */
    @Test
    public void test5() {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int r1 = c1.compare(10, 100);
        System.out.println(r1);

        Comparator<Integer> c2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int r2 = c2.compare(10, 100);
        System.out.println(r2);
    }

    /*
        语法格式6：当Lambda表达式体只有一条语句，return与大括号可以省略
     */
    @Test
    public void test6() {
        Comparator<Integer> c1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        int r1 = c1.compare(10, 100);
        System.out.println(r1);

        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);
        int r2 = c2.compare(10, 100);
        System.out.println(r2);
    }

    @Test
    public void test7() {
        Consumer<String> c1 = s -> {
            System.out.println(s);
        };
        c1.accept("一个是听的人当真了，一个是说的人当真了");

        Consumer<String> c2 = s -> System.out.println(s);
        c2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    @Test
    public void test8() {
        MyInterface mi = () -> {
            System.out.println("hh");
        };
        mi.method1();
    }
}
