package senior.day02.java;

/*
    例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式

    使用同步方法处理实现Runnable接口的方式中的线程安全问题
 */

class Window2 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (!setTicket()) {
                break;
            }
        }
    }

    private synchronized boolean setTicket() {  //  实例同步方法中的同步监视器：this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" +ticket);
            ticket--;
        }

        return ticket > 0;
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window = new Window2();

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
