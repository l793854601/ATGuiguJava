package basic.day03;

/*
    运算符之er：赋值运算符
    = += -= *= 、= %=
 */

public class AriTest2 {
    public static void main(String[] args) {
        //  赋值符号：=
        int i1 = 10;
        int j1 = 10;

        int i2, j2;
        i2 = j2 = 10;   //  连续赋值

        int i3 = 10, j3 = 20;   //  同类型的变量

        int num1 = 10;
        num1 += 2;  //  num1 = num1 + 2;
        System.out.println(num1);

        int num2 = 12;
        num2 %= 5;  //  2
        System.out.println(num2);

        short s1 = 10;
//        s1 = s1 + 2;  //  编译失败
        s1 += 2;    //  仍然不会改变自身（s1）的类型
        System.out.println(s1);

        //  开发中，如果希望实现变量+2的实现，有几种方法？（int num = 10）
        //  方式1：num = num + 2;
        //  方式2：num += 2;（推荐）

        //  开发中，如果希望实现变量+1的实现，有几种方法？（int num = 10）
        //  方式1：num = num + 1;
        //  方式2：num += 1;
        //  方式3：num++;（推荐）
    }
}
