package senior.day02.java;

/*
    例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式

    使用同步代码块解决继承Thread类的方式的线程安全问题

    说明：在继承Thread类创建多线程的方式中，我们可以考虑使用当前类对象来充当同步监视器。
 */

class Window extends Thread {

    private static int ticket = 100;

    public Window() {

    }

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {

            synchronized (Window3.class) {   //  类对象，唯一
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "卖票，票号为：" +ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window3 w1 = new Window3("窗口1");
        Window3 w2 = new Window3("窗口2");
        Window3 w3 = new Window3("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
