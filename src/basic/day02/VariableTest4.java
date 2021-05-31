package basic.day02;

public class VariableTest4 {
    public static void main(String[] args) {
        //  编码情况1
        long l = 123123;    //  此处结尾没有加L，就认为值为int
        System.out.println(l);

//        long l1 = 23423423414234124;   //  过大的整数

//        float f1 = 12.3;    //  此处没有加F，则认为值为double

        //  编码情况2
        //  整型常量，默认类型为int
        //  浮点型常量，默认类型为double
        byte b = 12;
//        byte b1 = b + 1;  //  byte与int相加，结果需要用int型接收
        int i1 = b + 1;

//        float f1 = b + 12.3;  //  12.3被认为是double，因此结果需要用double型接收
        double d1 = b + 12.3;
    }
}
