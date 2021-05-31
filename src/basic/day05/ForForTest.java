package basic.day05;

/*
    嵌套循环的使用
    1.嵌套循环：将一个循环结构A声明在另一个循环结构B的循环体中，就构成了嵌套循环

    2.外层循环：循环结构B
      内层循环：循环结构A

    3.说明：
      内层循环结构遍历一遍，只相当于外层循环的循环体执行了一次
      假设外层循环需要执行m次，内层循环需要执行n次，此时内层循环的循环体一共执行了：m*n次
 */

public class ForForTest {
    public static void main(String[] args) {
        /*
            ******
            ******
            ******
            ******
         */
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        /*
            *
            **
            ***
            ****
            *****
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        /*
            ****
            ***
            **
            *
         */
        for (int i = 4; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        /*
                *
               * *
              * * *
             * * * *
            * * * * *
             * * * *
              * * *
               * *
                *
         */
        //  上半部分（0~4行）
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //  下半部分
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
