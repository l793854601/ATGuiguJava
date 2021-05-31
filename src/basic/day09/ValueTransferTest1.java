package basic.day09;

/*
    方法的形参的传递机制：值传递（变量本身存的是什么值（基本数据类型、引用数据类型），就传什么值）

    1.形参：方法定义时，声明的小括号内的参数
      实参：方法调用时，实际传递给形参的数据

    2.值传递机制：
    如果参数是基本数据类型，此时实参赋给形参的是实参真是存储的数据值
    如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值
 */

public class ValueTransferTest1 {
    public static void main(String[] args) {
        //  交换两个变量的值
        int m = 10;
        int n = 20;
        System.out.println("交换前：m = " + m + ", n = " + n);

//        int temp = m;
//        m = n;
//        n = temp;
//        System.out.println("交换后：m = " + m + ", n = " + n);

        ValueTransferTest1 test = new ValueTransferTest1();
        test.swap(m, n);
        System.out.println("交换后：m = " + m + ", n = " + n);
    }

    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }
}
