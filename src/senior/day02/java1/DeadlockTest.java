package senior.day02.java1;

/*
    死锁的演示：

    分析：
    主线程调用a.foo(b)方法，获取了a锁，内部执行b.last();时，会尝试获取b锁
    子线程调用b.bar(a)方法，获取了b锁，内部执行a.last();时，会尝试获取a锁
    主线程等待子线程将b锁释放，而此时子线程也在等待主线程将a锁释放，两个线程相互等待，因此形成了死锁
 */

class A {
    public synchronized void foo(B b) {
        System.out.println("当前线程名："
                + Thread.currentThread().getName()
                + "进入了A实例的foo()方法");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前线程名："
                + Thread.currentThread().getName()
                + "企图调用B实例的的last()方法");

        b.last();
    }

    public synchronized void last() {
        System.out.println("当前线程名："
                + Thread.currentThread().getName()
                + "进入了A实例的last()方法");
    }
}

class B {

    public synchronized void bar(A a) {
        System.out.println("当前线程名："
                + Thread.currentThread().getName()
                + "进入了B实例的bar()方法");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前线程名："
                + Thread.currentThread().getName()
                + "企图调用A实例的的last()方法");

        a.last();
    }

    public synchronized void last() {
        System.out.println("当前线程名："
                + Thread.currentThread().getName()
                + "进入了B实例的last()方法");
    }
}

public class DeadlockTest implements Runnable {

    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args) {
        DeadlockTest dl = new DeadlockTest();
        new Thread(dl).run();
        dl.init();
    }
}
