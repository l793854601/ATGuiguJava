package basic.day06;

/*
    二维数组的使用：

    1.理解：
    对于二维数组的理解，我们可以看成是一维数组又作为另一个一维数组的元素而存在
    其实，从数组底层的运行机制来看，没有多维数组

    2.二维数组的使用：
      1）二维数组的声明和初始化
      2）如何调用（访问）数组的指定位置的元素
      3）如何获取数组的长度
      4）如何遍历数组元素
      5）数组元素的默认初始化值
      6）数组的内存解析
 */

public class ArrayTest2 {
    public static void main(String[] args) {
        //  1.二维数组的声明和初始化
        int[] arr = new int[]{1, 2, 3};
        //  静态初始化
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        //  动态初始化1
        String[][] arr2 = new String[3][2];
        //  动态初始化2
        String[][] arr3 = new String[3][];


        //  2.如何调用（访问）数组的指定位置的元素
        System.out.println(arr1[0][1]);
        System.out.println(arr2[1][1]);
//        System.out.println(arr3[1][0]); //  java.lang.NullPointerException


        //  3.如何获取数组的长度
        System.out.println(arr1.length);
        System.out.println(arr1[0].length);

        //  4.如何遍历数组元素
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
