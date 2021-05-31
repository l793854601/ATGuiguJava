package basic.day06;

/*
    数组元素的默认初始化值
        > 数组元素是整型：0
        > 数组元素是浮点型：0.0
        > 数组元素是char：0或'\0'或'\u0000'，而非"0"
        > 数组元素是boolean：false

        > 数组元素是引用数据类型：null
 */

public class ArrayTest1 {
    public static void main(String[] args) {
        //  5.数组元素的默认初始化值
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();

        short[] arr1 = new short[4];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println();

        float[] arr3 = new float[4];
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
        System.out.println();

        char[] arr4 = new char[4];
        for (int i = 0; i < arr4.length; i++) {
            System.out.println("----" + arr4[i] + "****");
        }
        if (arr4[0] == 0) {
            System.out.println("Hello world1!");
        }
        if (arr4[0] == '\0') {
            System.out.println("Hello world2!");
        }
        if (arr4[0] == '\u0000') {
            System.out.println("Hello world3!");
        }
        System.out.println();

        boolean[] arr5 = new boolean[5];
        for (int i = 0; i < arr5.length; i++) {
            System.out.println(arr5[i]);
        }
        System.out.println();

        String[] arr6 = new String[5];
        for (int i = 0; i < arr6.length; i++) {
            System.out.println(arr6[i]);
        }

        if (arr6[0] == null) {
            System.out.println("针不戳");
        }
    }
}
