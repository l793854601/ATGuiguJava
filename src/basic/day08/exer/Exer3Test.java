package basic.day08.exer;

/*
    3.1 编写一个程序，声明一个method方法，在方法中打印10*8的*型矩阵，在main方法中调用该方法
    3.2 修改上一个程序，在method方法中，除了打印10*8的*型矩阵，再计算该矩形的面积，并将其作为方法返回值
    3.3 修改上一个程序，在method方法中，提供m、n两个参数，方法中打印一个m*n的*型矩阵，并计算该举行的面积，将其作为方法返回值
 */

public class Exer3Test {
    public static void main(String[] args) {
        Exer3Test e3 = new Exer3Test();
        int area = e3.method(10, 8);
        System.out.println(area);
    }

    public int method(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        return m * n;
    }
}
