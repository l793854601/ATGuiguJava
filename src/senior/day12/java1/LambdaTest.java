package senior.day12.java1;

import org.junit.Test;

import java.util.Comparator;

/*
    Lambda表达式的使用举例
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int r1 = c1.compare(12, 21);
        System.out.println(r1);

        //  Lambda表达式的写法
        Comparator<Integer> c2 = (o1, o2) -> Integer.compare(o1, o2);
        int r2 = c2.compare(12, 21);
        System.out.println(r2);

        //  方法引用的写法
        Comparator<Integer> c3 = Integer::compare;
        int r3 = c3.compare(12, 21);
        System.out.println(r3);
    }
}
