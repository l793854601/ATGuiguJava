package senior.day02.java;

/*
    例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式

    使用同步方法处理继承Thread类的方式中的线程安全问题

    关于同步方法的总结：
    1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明同步监视器
    2.非静态的同步方法，同步监视器是：this
      静态的同步方法，同步监视器是：当前类对象
 */

class Window3 extends Thread {

    private static int ticket = 100;

    public Window3() {

    }

    public Window3(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (!sellTickets()) {
                break;
            }
        }
    }

    private static synchronized boolean sellTickets() {     //  静态同步方法中的同步监视器：当前类对象
        if (ticket > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" +ticket);
            ticket--;
        }

        return ticket > 0;
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3("窗口1");
        Window3 w2 = new Window3("窗口2");
        Window3 w3 = new Window3("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
