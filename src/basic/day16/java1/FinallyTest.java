package basic.day16.java1;

/*
    try-catch-finally的使用：

    1.finally是可选的
    2.finally中声明的是一定会被执行的代码，即使catch中又出现异常了、try中有return语句、catch中有return语句等情况
    3.数据库连接、输入/输出流、网络编程Socket等资源，JVM是不能自动回收的，需要我们自己手动进行释放。
      此时的资源释放，就需要声明在finally中
    4.try-catch-finally结构可以嵌套
 */

import org.junit.Test;

import java.io.*;

public class FinallyTest {

    public int method() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("我一定会被执行");
            return 3;
        }
    }

    @Test
    public void test1() {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("1 - catch ArithmeticException");
            int[] arr = new int[10];
            System.out.println(arr[10]);
            System.out.println("2 - catch ArithmeticException");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("我好帅啊~");
        }
    }

    @Test
    public void test2() {
        int num = method();
        System.out.println(num);
    }

    @Test
    public void test3() {
        InputStream fis = null;
        try {
            File file = new File("basic/day16/Hello.txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
