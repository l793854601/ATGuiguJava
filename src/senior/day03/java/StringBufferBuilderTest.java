package senior.day03.java;

import org.junit.Test;

/*
    关于StringBuffer与StringBuilder的使用

    String、StringBuffer、StringBuilder三者的异同？
    String：不可变的字符序列。底层使用char[]存储
    StringBuffer：可变的字符序列。线程安全的，效率低。底层使用char[]存储
    StringBuilder：可变的字符序列。JDK5.0新增。线程不安全的，效率高。底层使用char[]存储

    源码分析：
    String str1 = new String(); //  char[] value = new char[0];
    String str2 = new String(); //  char[] value = new char[] {'a', 'b', 'c'};

    StringBuffer sb1 = new StringBuffer();  //  char[] value = new char[16]; 底层创建了一个长度为16的char[]
    sb1.append('a');    //  value[0] = 'a';
    sb1.append('b');    //  value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc"); //  char[] value = new char[16 + "abc".length()];

    问题1：System.out.println(sb2.length());   //  3
    问题2：扩容问题：如果要添加的数据，底层放不下了，则需要扩容底层的数组
                    默认情况下，扩容为原来容量的2倍+2，同时，将原有数组中的元素复制到新的数组中
           指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

    StringBuffer的常用方法：
    总结：
    增：append(xxx);
    删：delete(int start, int end);
    改：setCharAt(int n, char n); replace(int start, int end, String str);
    查：charAt(int n)
    插：insert(int offset, xxx);
    长度：length();
    遍历：for() + charAt(int n)


    String、StringBuffer、StringBuilder三者的效率？
    从高到低：StringBuilder > StringBuffer > String
 */
public class StringBufferBuilderTest {

    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }

    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        //  拼接内容
        s1.append(1);
        s1.append('1');
        System.out.println(s1); //  abc11
        //  删除[startI, end)位置的内容
        s1.delete(2, 4);
        System.out.println(s1); //  ab1

        //  将[startI, end)位置的内容替换为str
        s1.replace(0, 2, "hello");
        System.out.println(s1); //  hello1

        //  在offset位置插入内容
        s1.insert(2, false);
        System.out.println(s1); //  hefalsello1

        //  反转内容
        s1.reverse();
        System.out.println(s1); //  1olleslafeh

        //  返回[startI, end)位置的字符序列
        System.out.println(s1.subSequence(1, 4));   //  oll

        //  将index位置的字符替换为ch
        s1.setCharAt(0, 'a');
        System.out.println(s1); //  aolleslafeh
    }

    @Test
    public void test3() {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String执行时间：" + (endTime - startTime));
    }
}
