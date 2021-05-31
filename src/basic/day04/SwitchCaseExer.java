package basic.day04;

/*
    从键盘分别输入年、月、日，判断这一天是当年的第一天

    注意：
    判断一年是否是闰年的标准：
    可以被4整除，但不能被100整除。或 可以被400整除

    说明：
    1.凡是可以使用switch-case的结构，都可以使用if-else，反之则不成立
    2.当写分支结构时，既可以使用switch-case（case情况不能太多），又可以使用if-else，优先使用switch-case。（原因：switch-case执行效率高）
 */

import java.util.Scanner;

public class SwitchCaseExer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入year：");
        int year = scanner.nextInt();

        System.out.println("请输入month：");
        int month = scanner.nextInt();

        System.out.println("请输入day：");
        int day = scanner.nextInt();

        int totalDays = 0;
        switch (month) {
            case 12:
                totalDays += 30;
            case 11:
                totalDays += 31;
            case 10:
                totalDays += 30;
            case 9:
                totalDays += 31;
            case 8:
                totalDays += 31;
            case 7:
                totalDays += 30;
            case 6:
                totalDays += 31;
            case 5:
                totalDays += 30;
            case 4:
                totalDays += 31;
            case 3: {
                //  判断year是否为闰年
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    totalDays += 29;
                } else {
                    totalDays += 28;
                }
            }
            case 2:
                totalDays += 31;
            case 1:
                totalDays += day;
        }

        System.out.println("输入的日期为" + year + "年的第" + totalDays + "天");
    }
}
