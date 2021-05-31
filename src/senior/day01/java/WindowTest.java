package senior.day01.java;

/*
    例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
    存在线程安全问题，待解决
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
            if (ticket > 0) {
                System.out.println(getName() + "卖票，票号为：" +ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("窗口1");
        Window w2 = new Window("窗口2");
        Window w3 = new Window("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
