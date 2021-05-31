package senior.day03.java;

import org.junit.Test;

/*
    String的使用

    String：字符串，使用一对""引起来表示
    1.String类声明为final，表示不可被继承
    2.String类实现了java.io.Serializable接口：表示String是支持序列化的
              实现了Comparable接口：表示字符串可比较大小
    3.String内部定义了final char[] value（jdk9之后为final byte[] value），用于存储字符串数据
    4.String代表不可变的字符序列，简称：不可变性
        体现：1.当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值
              2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
              3.当调用String的replace方法修改内部指定的字符/字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
    5.以字面量（区别于new）的方式给一个字符串赋值。此时的字符串值声明在字符串常量池中
    6.字符串常量池中不会存储相同内容（equals）的字符串

    String的实例化方式：
    方式1：通过字面量定义的方式
    方式2：通过new + 构造器的方式

    面试题：String s = new String("abc"); 在内存中创建了几个对象？
            两个：一个是堆空间中创建的对象，另一个是char[]对应的常量池中的数据
 */

public class StringTest {
    @Test
    public void test1() {
        String s1 = "abc";  //  字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);   //  比较两个对象的地址值：true

        s1 = "hello";
        System.out.println(s1);         //  hello
        System.out.println(s2);         //  abc
        System.out.println(s1 == s2);   //  false

        String s3 = s2;
        s3 += "def";
        System.out.println(s3);         //  abcdef
        System.out.println(s2 == s3);   //  false

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);         //  abc
        System.out.println(s5);         //  mbc
    }

    @Test
    public void test2() {
        //  通过字面量定义的方式：此时的s1、s2的内容（"javaEE"）声明在方法区的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";

        //  通过new + 构造器的方式：此时的s3、s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);   //  true
        System.out.println(s1== s3);    //  false
        System.out.println(s1 == s4);   //  false
        System.out.println(s3 == s4);   //  false

        Person p1 = new Person("Tome", 12);
        Person p2 = new Person("Tome", 12);
        System.out.println(p1.name.equals(p2.name));    //  true
        System.out.println(p1.name == p2.name);         //  true（name在构造器中是通过字面量赋值的）

        p1.name = "Jerry";
        System.out.println(p2.name);    //  Tome
    }

    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + "s2";
        String s7 = s1 + s2;

        /*
            结论：
            1.常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
            2.只要其中有一个是变量，结果就在堆中
            3.如果拼接的结果调用intern()方法，返回值就在常量池中
         */
        System.out.println(s3 == s4);   //  true
        System.out.println(s3 == s5);   //  false
        System.out.println(s3 == s6);   //  false
        System.out.println(s3 == s7);   //  false
        System.out.println(s5 == s6);   //  false
        System.out.println(s5 == s7);   //  false
        System.out.println(s6 == s7);   //  false
        System.out.println(s3 == s7.intern());  //  true
    }

    @Test
    public void test4() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);   //  false

        final String s4 = "javaEE"; //  此时s4为常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);   //  true
    }
}
