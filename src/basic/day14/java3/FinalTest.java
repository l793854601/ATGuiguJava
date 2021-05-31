package basic.day14.java3;

/*
    final：最终的

    1.final可以用来修饰的结构：类、方法、变量

    2.final用来修饰类：此类不能被其他类继承
        比如：String、System、StringBuffer等

    3.final用来修饰方法：此方法不能被重写
        比如：Object类中的getClass()方法等

    4.final用来修饰变量：此时的"变量"就成为常量了
        4.1 final修饰属性：可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
        4.2 final修饰局部变量：
            尤其是使用final修饰形参时，表明此时形参是一个常量，当我们调用此方法时，给常量赋值一个实参。
            一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。

    static final用来修饰一个属性：全局常量
 */

final class FinalA {

}

//  声明为final的类，不可作为其他类的父类了
//class B extends FinalA {
//
//}

//class C extends String {
//
//}

class AA {
    final public void show() {

    }
}

class BB extends AA {
    //  声明为final的方法，不能被子类重写
//    @Override
//    public void show() {
//        super.show();
//    }
}

public class FinalTest {
    final int WIDTH = 10;
    final int LEFT;
    final int RIGHT;
    {
        LEFT = 10;
    }

    public FinalTest() {
        RIGHT = 20;
    }

    public FinalTest(int n) {
        RIGHT = n;
    }

    public void doWidth() {
//        width = 20;
    }

    public void show() {
        final int num = 10;
//        num += 20;

        final int num1;
        num1 = 10;
    }

    public void show(final int num) {
//        num = 20;
    }

    public static void main(String[] args) {

    }
}
