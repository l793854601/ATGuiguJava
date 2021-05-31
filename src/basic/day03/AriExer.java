package basic.day03;

/*
    练习：随意给出一个三位数整数，打印显示它的个位数，十位数，百位数的值
    格式如下：
    数字xxx的情况如下：
    个位数：
    十位数：
    百位数：

    例如：
    数字153的情况如下：
    个位数：3
    十位数：5
    百位数：1
 */

public class AriExer {
    public static void main(String[] args) {
        int number = 187;
        int n1 = number / 100;  //  百位数
        int n2 = number % 100 / 10;  //  十位数
        int n3 = number % 10;   //  个位数

        System.out.println("数字" + number + "的情况如下：");
        System.out.println("个位数：" + n3);
        System.out.println("十位数：" + n2);
        System.out.println("百位数：" + n1);
    }
}
