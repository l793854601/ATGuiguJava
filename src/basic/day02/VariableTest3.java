package basic.day02;

/*
    强制类型转换：自动类型提升的逆运算

    1.需要使用强转符：()
    2.强制类型转换，可能会导致精度损失
 */

public class VariableTest3 {
    public static void main(String[] args) {
        double d1 = 12.3;
        int i1 = (int)d1;   //  容量大的数向容量小的数转换，需要强转
        System.out.println(i1); //  精度损失

        long l1 = 123;
        short s2 = (short)l1;
        System.out.println(l1); //  没有精度损失

        int i2 = 128;
        byte b = (byte)i2;
        System.out.println(b);  //  精度损失
    }
}
