package basic.day09;

/*
    方法的重载（overload）

    1.定义：在同一个类中，允许存在一个以上的同名方法，只要他们的参数个数或者参数类型不同即可。
        "两同一不同"
        "两同"：同一个类，相同方法名
        "一不同"：参数个数、参数类型不同

    2.举例：
        Arrays中重载的sort()、binarySearch()

    3.判断是否是方法重载：
        跟方法的权限修饰符、返回值类型、形参变量名、方法体都无关。

    4.在通过对象调用方法时，如何确定某一个方法：
        方法名 ---> 参数列表
 */

public class OverloadTest {

    public static void main(String[] args) {
        OverloadTest test = new OverloadTest();
        test.getSum(1, 2);
    }

    public void getSum(int i, int j) {
        System.out.println("1");
    }

    public void getSum(double i, double j) {
        System.out.println("2");
    }

    public void getSum(String s, int i) {
        System.out.println("3");
    }

    public void getSum(int i, String s) {
        System.out.println("4");
    }

//    public int getSum(int i, int j) {
//        return i + j;
//    }

//    public void getSum(int m, int n) {
//
//    }

//    private void getSum(int i, int j) {
//
//    }
}
