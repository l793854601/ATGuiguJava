package basic.day07;

/*
    创建一个长度为6的int型数组，要求数组元素的值都在[1, 30]之间，切实最忌赋值。
    同时，要求元素的值各不相同
 */

import java.util.Arrays;

public class ArrayTest1 {
    public static void main(String[] args) {

        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            //  [0, 1) * 30 = [0, 30)
            //  (int) (Math.random() * 30) + 1;
            int number = (int) (Math.random() * 30) + 1;
            array[i] = number;
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
