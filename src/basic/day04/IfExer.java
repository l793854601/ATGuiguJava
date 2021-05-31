package basic.day04;

/*
    if语句例题1
    岳小鹏参加Java考试后，他和父亲岳不群达成承诺：
    如果：
    成绩为100分时，奖励一辆BMW；
    成绩为(80，99]时，奖励一台iPhone xs max；
    成绩为[60，80]时，奖励一台iPad；
    其他时，什么奖励也没有。
    请从键盘输入岳小鹏期末成绩，并加以判断

    说明：
    1.else结构是可选的
    2.针对条件表达式：
      如果多个表达式之间是"互斥"关系（没有交集的关系），哪个判断和执行语句声明在上面还是下面，无所谓。
      如果多个表达式之间有交集关系，需要根据实际情况，考虑清楚应该将哪个if声明在上面。
      如果多个表达式之间有包含关系，通常情况下，需要将范围小的if声明在范围大的if上面，否则，范围小的if将没机会执行。
 */

import java.util.Scanner;

public class IfExer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入岳小鹏期末成绩：(0~100)");
        int score = scanner.nextInt();

//        if (score == 100) {
//            System.out.println("奖励一辆BMW");
//        } else if (score > 80 && score <= 99) {
//            System.out.println("奖励一台iPhone xs max");
//        } else if (score >= 60 && score <= 89) {
//            System.out.println("奖励一台iPad");
//        } else {
//            System.out.println("什么奖励也没有");
//        }

        if (score == 100) {
            System.out.println("奖励一辆BMW");
        } else if (score > 80) {
            System.out.println("奖励一台iPhone xs max");
        } else if (score >= 60) {
            System.out.println("奖励一台iPad");
        } else {
            System.out.println("什么奖励也没有");
        }
    }
}
