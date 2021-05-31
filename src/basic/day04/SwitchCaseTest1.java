package basic.day04;

/*
    例题：对学生成绩大于等于60分的，输出"及格"。低于60分的，输出"不及格"

    说明：如果switch-case结构中的多个case的执行语句相同，则可以合并
 */

public class SwitchCaseTest1 {
    public static void main(String[] args) {
        int score = 78;
        switch (score / 10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不及格");
                break;
            default:
                System.out.println("及格");
                break;
        }
    }
}
