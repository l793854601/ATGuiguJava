package basic.day14.java3;

class Father {
    static {
        System.out.println("111111111");
    }

    {
        System.out.println("222222222");
    }

    public Father() {
        System.out.println("333333333");
    }
}

/*
    111111111
    444444444
    777777777
    *********

    222222222
    333333333

    555555555
    666666666

    *********

    222222222
    333333333

    555555555
    666666666

    *********

    222222222
    333333333
 */

public class Son extends Father {
    static {
        System.out.println("444444444");
    }

    {
        System.out.println("555555555");
    }

    public Son() {
        System.out.println("666666666");
    }

    public static void main(String[] args) {
        System.out.println("777777777");
        System.out.println("*********");
        new Son();
        System.out.println("*********");
        new Son();
        System.out.println("*********");
        new Father();
    }
}
