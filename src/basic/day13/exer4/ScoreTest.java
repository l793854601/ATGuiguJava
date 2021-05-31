package basic.day13.exer4;

/*
    利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级
    提示：数组一旦创建，长度就固定不变，所以在创建数组钱就需要知道它的长度
    而向量类java.util.Vector可以根据需要动态伸缩（扩容）

    若与做高分相差10分内：A等
                 20分内：B等
                 30分内：C等
                 其他：D等
 */

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        Scanner scanner = new Scanner(System.in);
        int max = -1;

        System.out.println("请输入学生成绩，以负数代表输入结束：");
        while (true) {
            int score = scanner.nextInt();
            if (score < 0) {
                break;
            }
            if (score > 100) {
                System.out.println("输入的数据非法，请重新输入！");
                continue;   //  跳过本次循环，就不让下执行添加元素的逻辑了。
            }
            //  自动装箱，懒得写new了
            vector.add(score);

            if (max < score) {
                max = score;  //  自动装箱
            }
        }

        System.out.println("最高分：" + max);

        for (int i = 0; i < vector.size(); i++) {
            String level;
            int score = vector.get(i);
            if (max - score <= 10) {
                //  A等
                level = "A";
            } else if (max - score <= 20) {
                //  B等
                level = "B";
            } else if (max - score <= 30) {
                //  C等
                level = "C";
            } else {
                //  其他
                level = "其他";
            }
            System.out.println("学生" + i + "的成绩为：" + score + ", 等级为：" + level);
        }
    }
}
