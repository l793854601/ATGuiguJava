package basic.day07;

/*
    杨辉三角：
    使用二维数组打印一个10行杨辉三角
    提示：
    1.第一行有1个元素，第n行有n个元素
    2.每一行的第一个元素和最后一个元素都是1
    3.从第三行开始，对于一个非第一个元素和非最后一个元素：yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j]
 */

public class YanghuiTest {
    public static void main(String[] args) {
        //  声明二维数组
        int[][] yanghui = new int[10][];
        for (int i = 0; i < yanghui.length; i++) {
            //  给每一行数组赋值为新的数组
            yanghui[i] = new int[i + 1];

            //  遍历每一行数组，赋值
            for (int j = 0; j < yanghui[i].length; j++) {
                if (j == 0 || j == yanghui[i].length - 1) {
                    //  每一行的第一个元素和最后一个元素都是1
                    yanghui[i][j] = 1;
                } else {
                    //  yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
                    yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
                }
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
