package basic.day02;

/*
    变量的概念：
    1.内存中的一个存储区域
    2.该区域的数据可以在同一类型范围内不断变化（比如声明变量 int age = 10; a = 20;）
    3.变量是程序中最基本的存储单元。包含变量类型、变量名和存储的值

    变量的使用：
    1.java定义变量的格式：数据类型 变量名 = 值;，例如 int age = 10;
    2.使用变量名来访问这块区域的数据

    说明：
    1.变量必须先声明，再使用
    2.变量都定义在在其作用域内。在作用域内是有效的（出了作用域就失效了）
    3.同一个作用域不能声明两个名字相同的变量
 */

public class VariableTest {
    public static void main(String[] args) {
        //  变量的定义（声明+定义）
        int myAge = 20;
        //  变量的使用
        System.out.println("My age is " + myAge);

        //  变量的声明
        int myNumber;
        //  变量的定义（变量必须有值了才能被使用，否则会有编译错误）
        myNumber = 10;
        //  变量的使用
        System.out.println("My age is " + myNumber);

        {
            int yourNumber = 10;
            System.out.println("Your number is " + yourNumber);
        }

        //  变量出了作用域，就失效了
//        yourNumber = 20;

        //  同一个作用域（main方法内部），不能定义两个相同的变量
//        int myNumber = 300;
    }
}
