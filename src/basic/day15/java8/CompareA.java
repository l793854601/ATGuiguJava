package basic.day15.java8;

/*
    JDK8：除了可定义全局常量、抽象方法之前，还可以定义静态方法、默认方法
 */

public interface CompareA {
    //  静态方法
    static void method1() {
        System.out.println("CompareA：北京");
    }

    //  默认方法
    public default void method2() {
        System.out.println("CompareA：上海");
    }

    default void method3() {
        System.out.println("CompareA：深圳");
    }
}
