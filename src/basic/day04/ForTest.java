package basic.day04;

/*
    for循环结构的使用：

    1.循环结构的4个要素：
      初始化条件
      循环条件（boolean类型）
      循环体
      迭代条件

    2.for循环的结构
    for(初始化条件;循环条件;迭代条件) {
        循环体;
    }
 */

public class ForTest {
    public static void main(String[] args) {

        //  循环5次，打印"Hello world!"
        //  i在for循环中有效（作用域在for循环中）
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello world!");
        }

        //  练习
        int num = 1;
        for (System.out.print('a'); num <= 3; System.out.print('c'), num++) {
            System.out.print('b');
        }
        System.out.println();

        //  练习：遍历100以内的偶数，输出偶数的个数，输出所有偶数的和
        int count = 0;
        int sum = 0;
        for (int i = 0; i <= 100; i ++) {
            if (i % 2 == 0) {
                count++;
                sum += i;
            }
        }
        System.out.println("count = " + count + ", sum = " + sum);
    }
}
