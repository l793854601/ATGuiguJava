package basic.day03;

/*
    运算符之一：算数运算符
    + - * / % 前++ 后++ 前-- 后--

 */

public class AriTest {
    public static void main(String[] args) {
        //  除号：/
        int num1 = 12;
        int num2 = 5;
        int result = num1 / num2;   //  2
        System.out.println(result);

        int result2 = num1 / num2 * num2;   //  10
        System.out.println(result2);

        double result3 = num1 / num2;   //  2.0
        System.out.println(result3);

        double result4 = num1 / num2 + 0.0; //  2.0
        System.out.println(result4);

        double result5 = num1 / (num2 + 0.0); //  2.4
        System.out.println(result5);

        double result6 = (double)  num1 / num2; //  2.4
        System.out.println(result6);

        //  取余：%
        //  结果的符号与被除数（m1、m2、m3、m4）的符号相同
        //  开发中经常使用%判断能否被除尽
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 = " + m1 % n1);

        int m2 = -12;
        int n2 = 5;
        System.out.println("m2 % n2 = " + m2 % n2);

        int m3 = 12;
        int n3 = -5;
        System.out.println("m3 % n3 = " + m3 % n3);

        int m4 = -12;
        int n4 = -5;
        System.out.println("m4 % n4 = " + m4 % n4);

        //  前++：先自增1，再使用（赋值）
        //  后++：先使用（赋值），再自增1
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ", b1 = " + b1);  //  a1 = 11, b1 = 11

        int a2 = 10;
        int b2 = a2++;
        System.out.println("a2 = " + a2 + ", b2 = " + b2);  //  a2 = 11, b2 = 10

        int a3 = 10;
        a3++;   //  ++a3;
        int b3 = a3;
        System.out.println("a3 = " + a3 + ", b3 = " + b3);  //  a3 = 11, b3 = 11

        //  注意点：
        short s1 = 10;
//        s1 = s1 + 1;  //  编译失败
//        s1 = (short) (s1 + 1);
//        s1 += 1;
        s1++;   //  自增1不会改变自身变量的数据类型

        //  问题：
        byte bb1 = 127;
        bb1++;
        System.out.println("bb1 = " + bb1);

        //  前--：先自减1，再使用（赋值）
        //  后--：先使用（赋值），再自减1
    }
}
