package senior.day02.java2;

/*
    创建线程的方式四：使用线程池

    好处：
    1.提高响应速度（减少创建新线程的时间）
    2.降低资源消耗（重复利用线程池中的线程，不需要每次都创建）
    3.便于线程管理
        corePoolSize：核心池的大小
        maximumPoolSize：最大线程数
        keepAliveTime：线程没有任务时最多保持多长时间后会终止

    步骤：
    1.提供指定线程数量的线程池（ExecutorService接口的实现类）
    2.执行指定线程的操作，需要提供一个实心Runnable接口或Callable接口实现类的对象
    3.关闭线程池


    面试题：创建多线程有几种方式？
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class NumThread implements Runnable {

    @Override
    public void run() {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class NumThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //  设置线程池属性
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
//        executor.setCorePoolSize(15);
//        executor.setMaximumPoolSize(10);
//        executor.setKeepAliveTime();

        service.execute(new NumThread());       // 适合Runnable
        service.execute(new NumThread1());
//        service.submit();  // 适合Callable

        //  关闭线程池
        service.shutdown();
    }
}
