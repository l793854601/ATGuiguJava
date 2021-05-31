package basic.day06;

/*
    数组的概述：
    1.数组的理解：数组（Array），是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名
    并通过编号的方式对这些数据进行统一管理

    2.数组的相关概念：
    >数组名
    >下标（角标、索引）
    >元素
    >数组的长度（元素的个数）

    3.数组的特点：
      1）数组是有序排列的
      2）数组属于引用数据类型的变量，数组的元素既可以是基本数据类型，也可以数引用数据类型
      3）创建数组对象会在内存中开辟一整块连续的空间
      4）数组一旦创建成功，长度就确定了，且不能修改

    4.数组的分类：
      1）按照维数：一维数组、二维数组、...
      2）按照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组

    5.一维数组的使用：
      1）一维数组的声明和初始化
      2）如何调用（访问）数组的指定位置的元素
      3）如何获取数组的长度
      4）如何遍历数组元素
      5）数组元素的默认初始化值
      6）数组的内存解析
 */

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //  1.一维数组的声明和初始化
        int num;    //  声明
        num = 10;   //  初始化
        int id = 1001;  //  声明+初始化

        int[] ids;  //  声明一个整型数组
        //  1.1 静态初始化：数组的初始化和数组元素的赋值操作同时进行
        ids = new int[] {1001, 1002, 1003, 1004};
        //  2.1 动态初始化：数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];
        String[] names1 = {"1", "2", "3"};  //  声明、初始化写在一起，可以这么写，类型推断

        //  错误的写法
//        int[] arr1 = new int[];
//        int[] arr2 = new int[5]{0, 1, 2, 3, 4};

        //  总结：数组一旦初始化完成，其长度就确定了。

        //  2.如何调用（访问）数组的指定位置的元素
        //  数组的角标（索引）从0开始，到数组长度-1结束
        names[0] = "杨超越";
        names[1] = "吴宣仪";
        names[2] = "孟美岐";
        names[3] = "段奥娟";
        names[4] = "赖美云";
//        names[5] = "张紫宁";    //  越界会抛出异常：java.lang.ArrayIndexOutOfBoundsException

        //  3.如何获取数组的长度
        //  属性：length
        System.out.println(ids.length);
        System.out.println(names.length);

        //  4.如何遍历数组元素
//        System.out.println(names[0]);
//        System.out.println(names[1]);
//        System.out.println(names[2]);
//        System.out.println(names[3]);
//        System.out.println(names[4]);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
