package basic.day05;

/*
    while循环的使用

    1.循环结构的4个要素：
      初始化条件
      循环条件（boolean类型）
      循环体
      迭代条件

    2.while循环的结构：

    初始化条件;
    while (循环条件) {
        循环体;
        迭代条件;
    }

    说明：
        使用while循环结构，千万不能忘记迭代条件，否则可能会造成死循环（中间用break;则不会造成死循环）
        我们写的程序要避免死循环
        for循环与while循环是可以相互转换的

    算法：有限性
 */

public class WhileTest {
    public static void main(String[] args) {

        //  遍历100以内的所有偶数
        int i = 0;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
