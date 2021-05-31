package basic.day05;

/*
    题目：
    从键盘读入个数不确定的证书，并判断读入的正数和负数的个数，输入为0时程序结束。

    说明：
    1.不在循环条件部分闲置次数的结构：for (;;) 或 while (true)
    2.结束循环有几种方式？
        方式1：循环条件部分返回false
        方式2：在循环体中执行break;
 */

import java.util.Scanner;

public class ForWhileTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positiveNumberCount = 0;
        int negativeNumberCount = 0;

        //  方式1：
//        for (;;) {
//            System.out.println("请输入数字：");
//            int num = scanner.nextInt();
//            if (num > 0) {
//                positiveNumberCount++;
//            } else if (num < 0) {
//                negativeNumberCount++;
//            } else {
//                break;
//            }
//        }
        //  方式2：
        while (true) {
            System.out.println("请输入数字：");
            int num = scanner.nextInt();
            if (num > 0) {
                positiveNumberCount++;
            } else if (num < 0) {
                negativeNumberCount++;
            } else {
                break;
            }
        }

        System.out.println("正数的个数为：" + positiveNumberCount + ", 负数的个数为：" + negativeNumberCount);
    }
}
