package basic.day05;

/*
    题目：输入两个正整数m和n，求其最大公约数和最小公倍数
    比如：12和20的最大公约数是4，最小公倍数是60

    说明：break关键字的使用
 */

import java.util.Scanner;

public class ForTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入正整数m：");
        int m = scanner.nextInt();

        System.out.println("输入正整数n：");
        int n = scanner.nextInt();

        /*
            如何求最大公约数：
            以12、20为例
            首先，最大公约数一定不超过较小的数（小于等于12）
            用这个较小的数逆序遍历，直到找出12、20的最大公约数
         */
        //  获取两个数的较小值
        int min = Math.min(m, n);

        for (int i = min; i >= 1 ; i--) {
            if (m % i == 0 && n % i == 0) {
                System.out.println(m + "和" + n + "的最大公约数为" + i);
                break;
            }
        }

        /*
            如何求最大公倍数：
            以12、20为例
            首先，找出最大的数（20）
            用这个数，直到两数相乘，遍历，找出最小公倍数
         */
        int max = Math.max(m, n);
        for (int i = max; i <= m * n ; i++) {
            if (i % m == 0 && i % n == 0) {
                System.out.println(m + "和" + n + "的最小公倍数为" + i);
                break;
            }
        }
    }
}
