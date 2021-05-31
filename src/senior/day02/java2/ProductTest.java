package senior.day02.java2;

/*
    线程通信的应用：经典例题：生产者/消费者问题

    生产者（Producer）将产品交给电源（Clerk），而消费者（Consumer）从店员处取走产品。
    店员一次只能持有固定数量的产品（比如：20）。
    如果生产者试图生产更多的产品，店员会叫消费者停一下。
    如果店中有空位放产品了再通知生产者继续生产。
    如果店中没有产品了，店员会告诉消费者等一下。
    如果店中有产品了再通知消费者来取走产品。

    分析：
    1.是否是多线程问题？是：生产者线程，消费者线程
    2.是否有共享数据？有：店员（或产品）
    3.如何解决线程安全问题？同步机制
    4.是否涉及线程通信？是：需要wait()、notify()
 */

import basic.day15.java1.C;

import java.util.ArrayList;
import java.util.List;

class Clerk {
    private int count;

    public void addOneProduct() {
        count++;
        System.out.println(Thread.currentThread().getName() + "生产了一个产品，产品总量为：" + count);
    }

    public void reduceOneProduct() {
        count--;
        System.out.println(Thread.currentThread().getName() + "消费了一个产品，产品总量为：" + count);
    }

    public int getCount() {
        return count;
    }
}

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }

    private void produce() {

        synchronized (clerk) {
            if (clerk.getCount() < 20) {
                try {
                    System.out.println(Thread.currentThread().getName() + "正在生产产品");
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                clerk.addOneProduct();
                clerk.notify();
            } else {
                try {
                    clerk.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    private void consume() {
        synchronized (clerk) {
            if (clerk.getCount() > 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "正在消费产品");
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                clerk.reduceOneProduct();
                clerk.notify();
            } else {
                try {
                    clerk.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(producer);
            t.setName("生产者" + (i + 1));
            threads.add(t);
        }

        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(consumer);
            t.setName("消费者" + (i + 1));
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
