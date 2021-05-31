package senior.day01.java;

/*
    测试Thread中的常用方法：
    1.start()：启动当前线程，并调用当前线程的run()方法
    2.run()：通常需要重写thread类中的此方法，将创建的线程要执行的操作声明在此方法中
    3.currentThread()：静态方法，返回执行当前代码的线程
    4.getName()：获取当前线程的名字
    5.setName()：设置当前线程的名字
    6.yield()：静态方法，释放当前CPU的执行权
    7.join()：在线程a中调用线程b的join方法，线程a会进入阻塞状态，直到线程b执行完毕，线程a才结束阻塞状态
    8.stop()：已过时，当执行此方法时，强制结束当前线程
    9.sleep(long millis)：当让前线程睡眠指定的millis毫秒数在指定的millis毫秒时间内当前线程是阻塞状态
    10.isAlive()：判断当前线程是否还存活

    线程的优先级：
    1.优先级范围：
        MAX_PRIORITY：10
        MIN_PRIORITY：1
        NORMAL_PRIORITY：5 ---> 默认优先级

    2.获取、设置当前线程的优先级：
        getPriority()：获取当前线程的优先级
        setPriority(int newPriority)：设置当前线程的优先级

        说明：高优先级的线程要抢占低优先级线程的cpu执行前，但是只是从概率上讲，高优先级的线程高概率的情况下被执行。
              并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 */

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(getName() + ": " + getPriority() + " " + i);
            }

//            if (i % 20 == 0) {
//                yield();
//            }
        }
    }

    public HelloThread() {
    }

    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        h1.setName("线程一");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //  给主线程设置名字
        Thread.currentThread().setName("主线程！！");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority() + " " + i);
            }

//            if (i == 20) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(h1.isAlive());
        System.out.println(h1.getState());
    }
}