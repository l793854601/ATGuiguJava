package basic.day12.java3;

/*
    java中的this、super：
    参考Objective-C中的self、super
    this：调用当前实例的方法
    super：调用父类（直接父类、间接父类）实例的方法
 */

public class Son extends Father {
    public Son() {
        System.out.println(this.test());
        System.out.println(super.test());
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
