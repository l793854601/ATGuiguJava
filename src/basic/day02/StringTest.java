package basic.day02;

/*
    String类型变量的使用

    1.String属于引用数据类型，翻译为字符串
    2.声明String变量时，使用一对""
    3.String可以和8种基本数据类型做运算，且运算只能是连接运算：+，运算的结果仍为String
 */

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello World!";
        System.out.println(s1);

        String s2 = "a";
        String s3 = "";

//        char c = '';  //  编译不通过


        int number = 1001;
        String numberStr = "学号：";
        String info = numberStr + number;   //  连接运算
        String info1 = info + true;
        System.out.println(info1);


        //  练习1
        char c = 'a';   //  97
        int num = 10;
        String str = "hello";
        System.out.println(c + num + str);      //  107hello
        System.out.println(c + str + num);      //  ahello10
        System.out.println(c + (num + str));    //  a10hello
        System.out.println((c + num) + str);    //  107hello
        System.out.println(str + num + c);      //  hello10a

        //  练习2
        //  输出* *
        System.out.println('*' + '\t' + '*');   //  字符相加，结果为int
        System.out.println('*' + "\t" + '*');   //  *   *
        System.out.println('*' + '\t' + "*");
        System.out.println('*' + ('\t' + "*")); //  *   *
    }
}
