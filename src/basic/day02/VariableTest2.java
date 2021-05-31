package basic.day02;

/*
    基本数据类型之间的运算规则：

    前提：7种基本数据类型变量间的转换，不包含boolean

    1.自动类型提升（拓宽基本类型转换）：
        当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
        byte、char、short --> int --> long --> float --> double
        特别的：当byte、char、short三种类型的变量做运算时，结果要用int型接受

    2.强制类型转换（窄化基本类型转换）：

    说明：容量的大小，表示数的范围的大小，而不是所占字节的大小（比如：long跟float都为8个字节，但float所表示的数的范围大于long所表示的数的范围）
 */

public class VariableTest2 {
    public static void main(String[] args) {
        byte b1 = 2;
        int i1 = 12;
        //  编译不通过
//        byte b2 = b1 + i1;
        short s1 = b1;
        System.out.println(s1);

        int i2 = b1 + i1;
        System.out.println(i2);

        long l1 = b1 + i1;
        System.out.println(l1);

        float f1 = b1 + i1;
        System.out.println(f1);

        double d1 = b1 + i1;
        System.out.println(d1);

        char c1 = 'a';
        int i3 = 10;
        int i4 = c1 + i3;
        System.out.println(i4);

        short s2 = 10;
//        short s3 = c1 + s2;
//        char c2 = c1 + s2;
//        char c3 = b1 + b2;
        int i5 = c1 + s2;
        System.out.println(i5);
    }
}
