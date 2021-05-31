package basic.day09;

public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();
        int[] array = new int[] {32, 34, 32, 5, 3, 54, 654, -98, 0, -53, 5};

        int max = util.getMax(array);
        System.out.println("最大值：" + max);

        int min = util.getMin(array);
        System.out.println("最小值：" + min);

        System.out.print("反转前：");
        util.print(array);

        util.reverse(array);
        System.out.print("反转后：");
        util.print(array);

        System.out.print("排序前：");
        util.print(array);

        util.sort(array);
        System.out.print("排序后：");
        util.print(array);

        System.out.println("查找：");
        int index = util.getIndex(array, 5);
        if (index > 0) {
            System.out.println("元素5首次出现的索引：" + index);
        } else {
            System.out.println("未找到");
        }
    }
}
