package basic.day06;

/*
    从键盘读入学成成绩，找出最高分，并输出学生成绩等级
    > 成绩>=最高分-10  等级为'A'
    > 成绩>=最高分-20  等级为'B'
    > 成绩>=最高分-30  等级为'C'
    > 其余             等级为'D'

    提示：先读入学生人数，根据人数创建int数组，存放学生等级
 */

import basic.day04.ScannerTest;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入学生人数：");
        int count = scanner.nextInt();

        int[] scores = new int[count];
        System.out.println("请输入" + count + "个成绩：");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (score > max) {
                max = score;
            }
        }

        System.out.println("最高分是：" + max);

        for (int i = 0; i < scores.length; i++) {
            char grade = '\0';
            if (max - scores[i] <= 10) {
                grade = 'A';
            } else if (max - scores[i] <= 20) {
                grade = 'B';
            } else if (max - scores[i] <= 30) {
                grade = 'C';
            } else {
                grade = 'D';
            }

            System.out.println("student " + i + " score is " + scores[i] + " grade is " + grade);
        }
    }
}
