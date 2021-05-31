package basic.day10.java2;

/*
    一、package关键字的使用
    1.为了更好的实现项目中类的管理，提供了包的概念
    2.使用package声明类、接口所属的包，声明在源文件的首行（首行代码）
    3.包属于标识符，因此需要遵循标识符的命名规范，"见名知意"
    4.每"."一次，就代表一层文件目录

    补充：同一个包下，不能命名同名的类、接口（参考C++的namespace）
          不同的包下，可以命名同名的类、接口

    二、import关键字的使用
    import：导入
    1.在源文件中，显式的使用import结构导入指定包下的类、接口
    2.声明在包的声明之后，类的声明之前
    3.如果需要导入多个结构，则并列写出即可
    4.可以使用"xxx.*"的方式，表示可以导入xxx包下的所有结构
    5.String、System等核心的结构属于java.lang包下，如果使用的类、结构是java.lang包下的，则可以省略import结构
    6.如果使用的类、接口是当前包下的，则可以省略import结构
    7.如果在源文件中，使用了不同包下的同名的类、结构，则必须至少有一个类需要以全类名的方式显示
    8.使用"xxx.*"的方式表明可以使用xxx包下的所有结构，但如果使用过的是xxx子包下的结构，则仍然需要import显式导入
    9."import static"导入指定类或接口中给的静态结构：属性、方法
 */

import basic.day10.exer3.Account;
import basic.day10.java2.java3.Dog;

import java.lang.reflect.Field;
import java.util.*;

import static java.lang.System.*;
import static java.lang.Math.*;

public class PackageImportTest {
    public static void main(String[] args) {
        //  以下所涉及的类，都出自于java.util包下
        Arrays.toString(new int[] {1, 2, 3});
        new Scanner(System.in);
        new ArrayList();
        new HashMap();

        Account account = new Account(1000, 2000, 0.012);
        //  全类名显示
        basic.day10.exer4.Account account1 = new basic.day10.exer4.Account(1000);

        Dog dog = new Dog();

        //  Field在java.lang.reflect下
        Field field = null;

        //  java.lang.System
        out.println("Hello!");

        //  java.lang.Math
        sqrt(100);
    }
}
