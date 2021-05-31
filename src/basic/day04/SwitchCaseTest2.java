package basic.day04;

/*
    编写程序：从键盘上输入2019年的"month"和"day"，要求通过程序输出输入的日期为2019年的第几天

    说明：break在switch-case中是可选的
 */

import java.util.Scanner;

public class SwitchCaseTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入2019年的month：");
        int month = scanner.nextInt();

        System.out.println("请输入2019年的day：");
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
            case 3:
                totalDays += 28;
            case 2:
                totalDays += 31;
            case 1:
                totalDays += day;
        }

        System.out.println("输入的日期为2019年的第" + totalDays + "天");
    }
}
