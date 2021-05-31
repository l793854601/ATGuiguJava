package basic.day05;

/*
    100以内的所有质数的输出
    质数：也叫素数，只能被1和它本身整除的自然数 --> 从2开始到这个数减1结束，都不能被这个数本身整除
    最小的质数：2
 */

public class PrimeNumberTest {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                System.out.println(i);
            }
        }
    }
}
