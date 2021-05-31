package basic.day13.exer;

class Base1 {
    public void add(int a, int... arr) {
        System.out.println("Base1");
    }
}

class Sub1 extends Base1 {

    //  此处不会报错，int[]与int...是等价的，所以构成了重写
    //  因此实际运行中，调用的是子类重写的这个方法
    @Override
    public void add(int a, int[] arr) {
        System.out.println("Sub1_1");
    }

    public void add(int a, int b, int c) {
        System.out.println("Sub1_2");
    }
}

public class InterviewTest {
    public static void main(String[] args) {
        Base1 base = new Sub1();
        base.add(1, 2, 3);  //  此时调用的是子类中重写的public void add(int a, int[] arr)

        Sub1 sub1 = (Sub1) base;
        sub1.add(1, 2, 3);  //  此处调用的是public void add(int a, int b, int c)

        Sub1 sub2 = new Sub1();
        sub2.add(1, 2, 3);
    }
}
