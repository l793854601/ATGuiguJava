package basic.day16.java1;

/*
    异常处理的方式二：throws + 异常类型

    1. "throws + 异常类型"写在方法声明处。指明此方法执行时，可能会抛出的异常类型。
       一旦当方法执行时，出现异常，仍会在异常代码出生成一个异常类的对象。
       此对象满足throws后异常类型时，就会被抛出。异常后续的代码就不再被执行。

    2.体会：try-catch-finally：真正将异常处理掉了。
            throws：只是将异常抛给了方法的调用者，并没有将异常处理掉。

    3.开发中选择try-catch-finally还是throws？
        3.1 如果父类中被重写的方法没有声明throws，则子类重写的方法也不能声明throws。
            意味着子类重写的方法中有一次，则子类必须自身使用try-catch-finally方式处理。
        3.2 执行的方法a中，先后又调用了另外的几个方法，而这几个方法又是递进关系执行的。
            我们建议这几个方法使用throws的方式进行处理。而执行的方法a中可以考虑使用try-catch-finally处理。

 */

import java.io.*;

public class ExceptionTest2 {

    public static void main(String[] args) {
        try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        method3();
    }

    public static void method3() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws FileNotFoundException, IOException {
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("basic/day16/Hello.txt");
        InputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();

        System.out.println("hahaha!");
    }
}
