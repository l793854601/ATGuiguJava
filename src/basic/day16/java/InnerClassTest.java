package basic.day16.java;

public class InnerClassTest {

    /*
        在局部内部类的方法中，如果调用了局部内部类所声明的方法中的局部变量
        要求此局部变量声明为final的

        jdk7以及之前的版本，要求此局部变量显式的声明为final
        jdk8以及之后的版本，可以省略final的声明
     */
    public void method() {
        //  局部变量
        int num = 10;
//        num = 300;
        class AA {
            public void show() {
//                num = 20;
                System.out.println(num);
            }
        }
    }
}
