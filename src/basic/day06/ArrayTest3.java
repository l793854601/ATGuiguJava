package basic.day06;

/*
    二维数组的使用：
      规定：二维数组分为外层数组的元素、内层数组的元素
      int[][] arr = new int[4][3];
      外层元素：arr[0]，arr[1]等
      内层元素：arr[0][0]，arr[1][2]等

      5）数组元素的默认初始化值
      针对于初始化方式1，比如int[][] arr = new int[4][3];
         外层元素的初始化值：地址值（指向内层数组的地址值）
         内层元素的初始化值：与内层数组的初始化情况相同

      针对于初始化方式12，比如int[][] arr = new int[4][];
         外层元素的初始化值：null
         内层元素的初始化值：非法值（未被初始化）

      6）数组的内存解析
 */

import java.util.Arrays;

public class ArrayTest3 {
    public static void main(String[] args) {
        int[][] arr = new int[4][3];
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(arr[0][0]);

        float[][] arr1 = new float[4][3];
        System.out.println(Arrays.toString(arr1[0]));
        System.out.println(arr1[0][0]);

        String[][] arr2 = new String[4][3];
        System.out.println(Arrays.toString(arr2[0]));
        System.out.println(arr2[0][0]);

        int[][] arr3 = new int[4][];
        System.out.println(arr3[0]);    //  内层元素（数组）未被初始化，因此为null
//        System.out.println(arr3[0][0]); //  调用null，抛出空指针异常
    }
}
