package basic.day04;

/*
    如何从键盘获取不同类型的变量？
    需要使用Scanner类
    1.导入package（idea会自动导入）import java.util.Scanner;
    2.创建Scanner对象（实例化）
    3.使用nextXxx()方法获取指定类型的变量

    注意：
    需要根据相应的方法，来输入指定类型的值。如果输入的数据类型与要求的数据类型不匹配，则会抛出异常：java.util.InputMismatchException
    导致程序终止（如果没有处理异常）
 */

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
//        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("请输入你的姓名：");
            String name = scanner.next();

            System.out.print("请输入你的年龄：");
            int age = scanner.nextInt();

            System.out.print("请输入你的体重：");
            double weight = scanner.nextDouble();

            System.out.print("你是否相中我的了呢？（true/false）");
            boolean like = scanner.nextBoolean();

            //  对于char型的获取，Scanner没有提供相关的方法，只能通过String截取
            System.out.print("请输入你的性别：（男/女）");
            char gender = scanner.next().charAt(0); //  获取字符串中索引为0的字

            System.out.println("姓名：" + name);
            System.out.println("年龄：" + age);
            System.out.println("体重：" + weight);
            System.out.println("是否相中：" + like);
            System.out.println("性别：" + gender);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("登记结束");
    }
}
