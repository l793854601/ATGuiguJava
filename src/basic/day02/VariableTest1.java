package basic.day02;

/*
    java定义的数据类型

    一、变量按照数据类型分：

        基本数据类型：
            整型：byte、short、int、long
            浮点型：float、double
            字符型：char
            布尔型：boolean

        引用数据类型：
            类（class）
            接口（interface）
            数组（array）

     二、变量在类中声明的位置：
        成员变量：在方法体外，类内声明的变量
        局部变量：在方法体内声明的变量
 */

public class VariableTest1 {
    public static void main(String[] args) {
        //  1.整型：byte（1字节=8bit）、short（2字节）、int（4字节）、long（8字节）
        //  byte范围：-128~127
        byte b1 = 12;
        byte b2 = -128;
        System.out.println("b1 = " + b1 + ", b2 = " + b2);

        //  128已经超出byte的取值范围
//        b2 = 128;

        //  声明long型变量，其值必须以小写l或大写L结尾（建议以大写L结尾，小写l容易产生视觉上的歧义）
        //  通常定义整型变量时，使用整型即可（时间戳是以毫秒为单位的，要使用long）
        short s1 = 128;
        int i1 = 1234;
        long l1 = 1000L;
        System.out.println("s1 = " + s1 + ", i1 = " + i1 + ", l1 = " + l1);


        //  2.浮点型：float（4字节）、double（8字节）
        //  浮点型，表示带小数点的数值
        //  float表示的数值范围比long还大（因此float可向上提升为long）

        double d1 = 123.3;
        System.out.println("d1 = " + (d1 + 1));

        //  定义float类型变量时，变量结尾要以大写F或小写f结尾
        float f1 = 12.3f;
        System.out.println("f1 = " + f1);

        //  通常，定义浮点型变量时，使用double（相比于float、double范围大、精度高，且定义时，值结尾不用写f）

        //  3.字符型：char（1字符=2字节）
        char c1 = 'A';
        System.out.println("c1 = " + c1);

        //  字符型，内部只能写一个字符
//        c1 = 'AB';

        char c2 = '1';
        char c3 = '中';
        char c4 = 'は';
        System.out.println("c2 = " + c2 + ", c3 = " + c3 + ", c4 = " + c4);

        //  表示方式：1.声明一个字符 2.转义字符 3.直接使用unicode值表示字符型常量
        char c5 = '\n'; //  \n：换行
        System.out.print("Hello");
        System.out.print(c5);
        System.out.print("World");
        System.out.println();

        c5 = '\t';  //  \t：制表符
        System.out.print("Hello");
        System.out.print(c5);
        System.out.print("World");
        System.out.println();

        char c6 = '\u0043'; //  \u0043对应的字符为C
        System.out.println("c6 = " + c6);

        //  4.布尔型：boolean
        //  只能取两个值之一：true、false
        //  某些编程语言，如C、Objective-C，可以用0表示假、非0表示真，但java不可以，java中必须严格使用true、false表示真假
        //  boolean常用于条件判断、循环中
        boolean bl1 = true;
        bl1 = false;
        System.out.println("bl1 = " + bl1);

        boolean isMarried = true;
        if (isMarried) {
            System.out.println("你不能参加\"单身party\"了！很遗憾");
        } else {
            System.out.println("你可以多谈谈女朋友！");
        }
    }
}
