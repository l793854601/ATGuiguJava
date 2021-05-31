package basic.day09;

/**
 * 自定义数组工具类
 */
public class ArrayUtil {

    //  求数组最大值
    public int getMax(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result < array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    //  求数组最小值
    public int getMin(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    //  求数组的总和
    public int getSum(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    //  求数组的平均值
    public int getAvg(int[] array) {
        int sum = getSum(array);
        int result = sum / array.length;
        return result;
    }

    //  反转数组
    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[array.length - i - 1];
        }
    }

    //  复制数组
    public int[] copy(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    //  数组排序（冒泡排序）
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //  遍历数组
    public void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //  查找指定元素
    public int getIndex(int[] array, int dest) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == dest) {
                return i;
            }
        }
        return -1;
    }
}
