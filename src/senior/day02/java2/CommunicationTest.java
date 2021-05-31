package senior.day02.java2;

/*
    线程通信的例子：使用两个线程打印1-100，线程1，线程2交替打印

    涉及到的三个方法：
    wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
    notify()：一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，则唤醒优先级最高的那个线程
    notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程

    说明：
    1.wait()、notify()、notifyAll()这三个方法必须使用在同步代码块或同步方法中
    2.wait()、notify()、notifyAll()这三个方法的调用者，必须是同步代码块或同步方法中中的同步监视器
      否则，会出现IllegalMonitorStateException异常
    3.wait()、notify()、notifyAll()这三个方法是定义在java.lang.Object类中

    面试题：sleep()和wait()方法的异同？
    相同点：一旦执行方法，可以使得当前线程进入阻塞状态
    不同点：1）两个方法声明的位置不同：sleep()在Thread中声明，wait()在Object中声明
           2）调用的要求不同：sleep()可以在任何需要的场景下调用
                             wait()必须使用在同步代码块或同步方法中
           3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中
                                     sleep()不会释放同步监视器
                                     wait()会释放同步监视器
 */

class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                //  调用此方法，会唤醒调用过wait()方法而阻塞的线程
                notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(100);  //  sleep()不会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        //  使得调用如下wait()方法的线程进入阻塞状态
                        //  wait()方法会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        t1.setName("线程1");

        Thread t2 = new Thread(number);
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
