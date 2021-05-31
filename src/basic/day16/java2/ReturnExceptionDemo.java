package basic.day16.java2;

public class ReturnExceptionDemo {

    static void methodA() {
        try {
            System.out.println("进入方法A");
            //  此处，在throw异常之前，会执行finally
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("用B方法的finally");
        }
    }

    /*
        进入方法A
        用A方法的finally
        制造异常
        进入方法B
        用B方法的finally
     */

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        methodB();
    }
}
