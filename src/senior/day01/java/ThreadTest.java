package senior.day01.java;

/*
    多线程的创建
    方式一：继承与Thread类
    1.创建一个继承于Thread类的子类
    2.重写Thread类中的run()方法 --> 将此线程执行的操作声明在run()中
    3.创建Thread类的子类的对象
    4.通过此对象调用start()方法

    例子：遍历100以内的所有偶数
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        /*
            start()方法的作用：
            1.启动当前线程
            2.执行run()方法
         */
        myThread.start();

        //  问题一：不能通过调用run()方法的方式开启线程
//        myThread.run();

        //  问题二：不可以让已经start()的线程再调用start()方法执行：java.lang.IllegalThreadStateException
//        myThread.start();
        //  需要重新创建一个线程的对象
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //  如下方法仍然是在main()方法中执行的
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        }
    }
}
