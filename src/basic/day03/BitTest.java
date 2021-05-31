package basic.day03;

/*
    运算符之五：位运算

    结论：
    1.位运算符操作的都是整型的数据
    2.<<：在一定范围内，每向左移1位，相当于*2
      >>：在一定范围内，每向右移1位，相当于/2

    面试题：最高效方式的计算2 * 8？ 2 << 3 或者 8 << 1
 */

public class BitTest {
    public static void main(String[] args) {
        int i = 21;
        System.out.println("i << 2 = " + (i << 2));
        System.out.println("i << 3 = " + (i << 3));
        System.out.println("i << 27 = " + (i << 27));   //  最高位变为1，因此为负数

        i = -21;
        System.out.println("i << 2 = " + (i << 2));
        System.out.println("i << 3 = " + (i << 3));
        System.out.println("i << 27 = " + (i << 27));

        int m = 12;
        int n = 5;
        /*
            &：都为1，则为1，否则为0
                0000 1100
              & 0000 0101
         -----------------
                0000 0100   4
         */
        System.out.println("m & n = " + (m & n));   //  4

        /*
            |：只要一个为1，则为1，否则为0
                0000 1100
              | 0000 0101
         -----------------
                0000 1101   13
         */
        System.out.println("m | n = " + (m | n));   //  13

        /*
            ^：不相同为1，否则为0
                0000 1100
              ^ 0000 0101
         -----------------
                0000 1001   9
         */
        System.out.println("m ^ n = " + (m ^ n));   //  9


        //  练习：交换两个变量的值
        int num1 = 21;
        int num2 = 32;
        System.out.println("交换前：num1 = " + num1 + ", num2 = " + num2);

        //  方式1：声明一个临时变量（推荐）
//        int temp = num1;
//        num1 = num2;
//        num2 = temp;
//        System.out.println("交换后：num1 = " + num1 + ", num2 = " + num2);

        //  方式2：加法
        //  好处：不用定义临时变量
        //  坏处：相加操作可能超出存储范围，有局限性（数值型可以，非数值型无法相加）
//        num1 = num1 + num2;
//        num2 = num1 - num2;
//        num1 = num1 - num2;
//        System.out.println("交换后：num1 = " + num1 + ", num2 = " + num2);

        //  方式3：使用位运算符（解决了方式2中可能超出存储范围的问题）
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("交换后：num1 = " + num1 + ", num2 = " + num2);
    }
}
