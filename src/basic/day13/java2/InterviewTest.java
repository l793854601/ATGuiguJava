package basic.day13.java2;

/*
    关于包装类使用的面试题
 */

import org.junit.Test;

public class InterviewTest {

    /*
        说明：
        ? 表达式1 : 表达式2
        三元运算符，要求表达式1、表达式2的类型要统一
        因此：Integer此处会被提升为Double
     */
    @Test
    public void test1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1); //  1.0
    }

    @Test
    public void test2() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            new Double(2.0);
        System.out.println(o2); //  2.0
    }

    /*
        说明：
        Integer内部有个IntegerCache作为缓存池：范围：-127~128
        JDK 5.0之后，只用自动装箱的方式，将int赋值给Integer，实际上调用的是Integer的valueOf(int i)方法
        valueOf(int i)方法内部会从IntegerCache中取，如果不在IntegerCache范围内（-127~128），则会新创建对象
        因此：
            Integer m = 1;
            Integer n = 1;
            m、n都是从IntegerCache中取出的缓存的对象

            Integer x = 128;
            Integer y = 128;
            x、y为新创建的对象
     */

    @Test
    public void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //  false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); //  true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); //  false
    }
}
