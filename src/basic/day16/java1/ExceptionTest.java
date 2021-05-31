package basic.day16.java1;

/*
    一、异常的体系结构：
    java.lang.Throwable
        |----- java.lang.Error：严重问题，一般不编写针对性的代码进行处理
        |----- java.lang.Exception：异常，可以进行处理
            |----- 编译时异常（checked）
                |----- IOException
                    |----- FileNotFoundException
                |----- ClassNotFoundException
            |----- 运行时异常（unchecked/RuntimeException）
                |----- NullPointerException
                    |----- IndexOutOfBoundsException
                        |----- ArrayIndexOutOfBoundsException
                        |----- StringIndexOutOfBoundsException
                |----- ClassCastException
                |----- NumberFormatException
                |----- InputMismatchException
                |----- ArithmeticException

    面试题：常见的异常有哪些？举例说明
 */

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class ExceptionTest {

    //  NullPointerException
    @Test
    public void test1() {
        int[] arr = null;
        System.out.println(arr[0]);

        String str = null;
        System.out.println(str.charAt(0));
    }

    //  IndexOutOfBoundsException
    @Test
    public void test2() {
        //  ArrayIndexOutOfBoundsException
        int[] arr = new int[10];
        System.out.println(arr[10]);

        //  StringIndexOutOfBoundsException
        String str = "abc";
        System.out.println(str.charAt(3));
    }

    //  ClassCastException
    @Test
    public void test3() {
        Object o = new Object();
        String s = (String) o;
    }

    //  NumberFormatException
    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        Integer i = Integer.parseInt(str);
    }

    //  InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();    //  此处输入非数字，回车，则会抛出InputMismatchException
    }

    //  ArithmeticException
    @Test
    public void test6() {
        System.out.println(1 / 0);
    }

    //  FileNotFoundException
    @Test
    public void test7() {
        try {
            File file = new File("basic/day16/Hello.txt");
            InputStream fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
