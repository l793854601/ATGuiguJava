package basic.day09;

/*
    递归方法的使用（了解）
    1.递归方法：一个方法体内调用了它自身
    2.方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
      递归一定要向已知的方向递归，否则这种递归就变成了无穷递归，类似于死循环（stackOverflow）
 */

public class RecursionTest {
    public static void main(String[] args) {
        //  例1：求1~100内所有自然数的和
        //  方式1：
//        int sum = 0;
//        for (int i = 1; i <=  100; i++) {
//            sum += i;
//        }
//        System.out.println(sum);

        //  方式2：
        RecursionTest test = new RecursionTest();
        int sum = test.getSum(100);
        System.out.println(sum);

        int value = test.f(10);
        System.out.println(value);

        for (int i = 0; i < 10; i++) {
            System.out.println(test.fibonacci(i));
        }
    }

    //  求1~100内所有自然数的和（使用递归）
    public int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return getSum(n - 1) + n;
    }

    //  已知一个数列：f(0) = 1, f(1) = 4, f(n+2) = 2 * f(n + 1) + f(n)
    //  其中n是大于0的整数，求f(10)的值
    public int f(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 4;
        }
        return 2 * f(n - 1)  + f(n - 2);
    }

    //  斐波那列数列
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
