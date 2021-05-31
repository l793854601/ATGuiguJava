package basic.day05;

/*
    do-while循环的使用：

    1.循环结构的4个要素：
      初始化条件
      循环条件（boolean类型）
      循环体
      迭代条件

    2.do-while循环结构：

    初始化条件;
    do {
        循环体;
        迭代条件;
    } while (循环条件)

    说明：
    1.do-while至少会执行一次循环体
    2.开发中，使用for和while更多一些。较少使用do-while
 */

public class DoWhileTest {
    public static void main(String[] args) {
        //  遍历100以内的偶数，并计算所有偶数的和以及偶数的个数
        int sum = 0;
        int count = 0;
        int num = 0;
        do {
            if (num % 2 == 0) {
                System.out.println(num);
                sum += num;
                count++;
            }
            num++;
        } while (num <= 100);

        System.out.println("总和为：" + sum + "，个数为：" + count);
    }
}
