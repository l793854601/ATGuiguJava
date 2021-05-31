package senior.day02.java1;

/*
    解决线程安全问题的方式三：Lock锁 ---> JDK 5.0新增

    步骤：
    1.实例化Lock对象（ReentrantLock）
    2.调用Lock对象的lock()方法
    3.执行代码逻辑
    4.调用Lock对象的unlock()方法

    注意：使用Lock的方式，仍然需要保证lock对象是同一个对象

    面试题1：synchronized与Lock的异同？
        相同：都可以解决线程安全问题
        不同：synchronized机制在执行完相应同步代码以后，自动释放同步监视器
              Lock需要手动的启动同步（lock()），同事结束同步也需要手动实现（unlock()）

    面试题2：如何解决线程安全问题？
        同步代码块、同步方法、Lock

 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Window implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            //  使用try - finally，可保证，在执行内部逻辑时，即使抛出异常，unlock()方法最终也会被调用
            try {
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" +ticket);
                    ticket--;
                } else {
                    break;
                }

            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        t1.setName("窗口1");

        Thread t2 = new Thread(window);
        t2.setName("窗口2");

        Thread t3 = new Thread(window);
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
