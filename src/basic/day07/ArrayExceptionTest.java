package basic.day07;

/*
    数组中的常见异常
    1.数组角标越界（java.lang.ArrayIndexOutOfBoundsException）
    2.空指针异常（java.lang.NullPointerException）
 */

public class ArrayExceptionTest {
    public static void main(String[] args) {
        //  1.数组角标越界（java.lang.ArrayIndexOutOfBoundsException）
        int[] arr = new int[] {1, 2, 3, 4};
//        System.out.println(arr[5]);   //  访问的索引超出数组长度范围（合法范围为：[0, arr.length - 1]），则会抛出java.lang.ArrayIndexOutOfBoundsException

        //  2.空指针异常（java.lang.NullPointerException）
        //  情况1：
//        int[] arr1 = new int[] {1, 2, 3};
//        arr1 = null;
//        System.out.println(arr1.length);    //  调用null的引用类型变量的方法，则会抛出java.lang.NullPointerException

        //  情况2：
//        int[][] arr2 = new int[4][];
//        System.out.println(arr2[0].length);

        //  情况3：
//        String[] arr3 = new String[3];
//        System.out.println(arr3[0].toString());
    }
}
