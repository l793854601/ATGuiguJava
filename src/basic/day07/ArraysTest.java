package basic.day07;

/*
    java.util.Arrays：操作数组的工具类，里面定义了很多操作数组的方法
 */

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        //  判断两个数组是否相等
        int[] arr1 = new int[] {1, 2, 3, 4};
        int[] arr2 = new int[] {1, 3, 2, 4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);

        //  输出数组信息
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        //  将指定的值填充到数组中
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));

        //  排序
        Arrays.sort(arr2);  //  默认为从小到大的顺序
        System.out.println(Arrays.toString(arr2));

        //  二分查找（前提是数组一定要有顺序）
        int[] arr3 = new int[] {-98, 34, 2, 34, 54, 66, 79, 105, 210, 333};
        int index = Arrays.binarySearch(arr3, 210);
        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println("Not Found!");
        }
    }
}
