package basic.day03;

/*
    运算符之六：三元运算符
    1.结构：(条件表达式) ? 表达式1 : 表达式2;

    2.说明：
        条件表达式的结果为boolean类型
        根据条件表达式真或假，决定执行表达式1，还是表达式2
        如果条件表达式为true，则执行表达式1
        如果条件表达式为false，则执行表达式2
        表达式1与表达式2的值必须为同意类型或者可以被提升为同一类型
        三目运算符可以嵌套，但可读性太差，不建议

    3. 三目运算符可以改写成if-else语句，反之不成立

    4.如果程序既可以使用三元运算符，又可以使用if-else结构，那么优先选择三元运算符。
      原因：简洁，效率高（三元运算符仅仅是一个运算符）
 */

public class TernaryOperatorTest {
    public static void main(String[] args) {
        //  获取两个整数的较大值
        int m = 12;
        int n = 5;
        int max = (m > n) ? m : n;
        System.out.println(max);

        double num = (m > n) ? 2 : 1.0;
        System.out.println(num);

        //  获取三个数的最大值
        int n1 = 12;
        int n2 = 30;
        int n3 = -43;
        int nMAX = (n1 > n2) ? n1 : n2;
        nMAX = (nMAX > n3) ? nMAX : n3;
    }
}
