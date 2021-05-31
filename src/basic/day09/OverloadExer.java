package basic.day09;

/*
    1.编写程序，定义三个重载方法并调用，方法名为mOL
    三个方法分别接受一个int参数、两个int参数、一个字符串参数
    分别执行平方运算并输出结果、相乘并输出结果、输出字符串信息
    在主类的main方法中分别用参数区分调用三个方法

    2.定义三个重载方法max
    第一个方法：求两个int值中的最大值
    第二个方法：求两个double值中的最大值
    第三个方法：求三个double值中的最大值
    并分别调用三个方法
 */

public class OverloadExer {
    public static void main(String[] args) {
        OverloadExer exer = new OverloadExer();
        exer.mOL(10);
        exer.mOL(10, 20);
        exer.mOL("Hello world!");

        System.out.println(exer.max(10, 29));
        System.out.println(exer.max(10.1, 20.3));
        System.out.println(exer.max(99.8, 22.1, 90.8));
    }

    public void mOL(int i) {
        System.out.println(i * i);
    }

    public void mOL(int i, int j) {
        System.out.println(i * j);
    }

    public void mOL(String s) {
        System.out.println(s);
    }

    public int max(int i, int j) {
        return i > j ? i : j;
    }

    public double max(double d1, double d2) {
        return d1 > d2 ? d1 : d2;
    }

    public double max(double d1, double d2, double d3) {
        if (d1 > d2 && d1 > d3) {
            return d1;
        }
        if (d2 > d1 && d2 > d3) {
            return d2;
        }
        return d3;
    }
}
