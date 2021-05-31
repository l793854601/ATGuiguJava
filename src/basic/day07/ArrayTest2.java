package basic.day07;

/*
    定义一个int型的一维数组，包含10个元素，分别赋一些随机整数
    然后求出所有元素的最大值，最小值，平均值，并输出
    要求：所有随机数都是两位数[10, 99]

    公式：(int) (Math.random() * (99 - 10 + 1) + 10)
 */

import java.util.Arrays;

public class ArrayTest2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }
        int min = arr[0];
        int max = arr[0];
        int sum = arr[0];
        int avg = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            sum += arr[i];
        }
        avg = sum / arr.length;

        System.out.println(Arrays.toString(arr));
        System.out.println("max = " + max + ", min = " + min + ", sum = " + sum + ", avg = " + avg);
    }
}
