package basic.day05;

/*
    九九乘法表
    1 * 1 = 1
    1 * 2 = 2   2 * 2 = 4
    1 * 3 = 3   2 * 3 = 6   3 * 3 = 9
    ...
    ... 9 * 9 = 81
 */

public class NineNineTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + j * i);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
