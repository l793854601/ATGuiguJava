package basic.day15.java1;

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

public class C extends B implements A {

    private void pX() {
        //  编译不通过，因为x是不明确的
//        System.out.println(x);
        System.out.println(super.x);    //  调用父类（B）中的x
        System.out.println(A.x);    //  调用接口（A）中的x
    }

    public static void main(String[] args) {
        new C().pX();
    }
}
