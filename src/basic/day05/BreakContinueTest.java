package basic.day05;

/*
    break和continue关键字的使用
               使用范围         循环中使用的作用（不同点）
    break：    switch-case      结束当前循环
               循环结构         结束（跳过）当次循环
    continue： 循环结构

    相同点：同一作用域内，break、continue不能有执行语句
 */

public class BreakContinueTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                break;
//                System.out.println("Hello world!");
            }
            System.out.println(i);
        }
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                continue;
//                System.out.println("Hello world!");
            }
            System.out.println(i);
        }
        System.out.println();

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j % 4 == 0) {
                    break;  //  默认跳出包过此关键字最近的一层循环。
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        label: for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j % 4 == 0) {
                    break label;  //    结束指定标识的那层循环结构
                }
                System.out.print(j + " ");
            }
        }
        System.out.println();

        label: for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j % 4 == 0) {
                    continue label; //    结束指定标识的那层循环结构的当次循环
                }
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }
}
