package basic.day13.java;

import java.time.Year;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Man();
        //  不能调用子类所独有的属性、方法（编译器不允许），在编译期，p1是Person类型
//        p1.isSmoking = YES;
//        p1.earnMoney();

        //  有了对象的多态性以后，内存实际上是加载了子类特有的属性、方法。
        //  由于声明为父类类型，导致编译时，只能调用父类中声明的的属性、方法，无法调用子类特有的属性、方法
        //  如何才能调用子类特有的属性、方法？（向下转型）

        //  使用强转时，可能会出现ClassCastException，因此需要先判断一下对象真正的类型
//        Woman w1 = (Woman) p1;
//        w1.isBeauty = true;
//        w1.goShopping();

        /*
            instanceof关键字的使用：
            a instanceof A：判断对象a是否是类A的实例。如果是，则返回true，否则返回false

            使用场景：
            为了避免在向下转型时，出现ClassCastException。
            在向下转型之前，使用instanceof判断，如果返回true，则进行向下转型，如果返回false，则终止向下转型

            如果a instanceof A返回true，且类B是类A的父类，则a instanceof B也返回true
         */

        if (p1 instanceof Woman) {
            Woman w1 = (Woman) p1;
            w1.isBeauty = true;
            w1.goShopping();
        }

        if (p1 instanceof Man) {
            Man m1 = (Man) p1;
            m1.isSmoking = true;
            m1.earnMoney();
        }

        //  练习：
        //  问题一：编译时通过，运行时不通过
        //  举例1：
//        Person p3 = new Woman();
//        Man m2 = (Man) p3;

        //  举例2：
//        Person p4 = new Person();
//        Man m3 = (Man) p4;

        //  问题二：编译通过，运行也通过
        Object obj = new Woman();
        Person p2 = (Person) obj;

        //  问题三：编译不过，运行也不过
//        Man m4 = new Woman();
    }
}
