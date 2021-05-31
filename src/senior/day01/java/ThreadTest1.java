package senior.day01.java;

/*
    创建多线程的方式二：实现Runnable接口
    1.创建一个实现了Runnable接口的类
    2.实现类去实现Runnable中的run()方法
    3.创建实现类的对象
    4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
    5.通过Thread类的对象，调用start()方法


    比较创建线程的两种方式：
    开发中：优先选择实现Runnable接口的方式
    原因：1.实现的方式没有类的单继承的局限性
          2.实现的方式更适合来处理多个线程有共享数据的情况

    联系：两种方式都需要重写run()方法，将线程需要执行的逻辑声明在run()中
 */

class MRun implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MRun run = new MRun();
        Thread thread1 = new Thread(run);
        thread1.setName("线程1");
        thread1.start();

        Thread thread2 = new Thread(run);
        thread2.setName("线程2");
        thread2.start();
    }
}
