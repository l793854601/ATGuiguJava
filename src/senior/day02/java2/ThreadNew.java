package senior.day02.java2;

/*
    创建线程的方式三：实现Callable接口 ---> JDK 5.0新增

    Callable比Runnable强大：
    1.call()是可以有返回值的
    2.call()方法是可以抛出异常的，被外面的操作捕获
    3.Callable是支持泛型的

    步骤：
    1.创建一个实现Callable的实现类
    2.实现call()方法，将此线程需要执行的操作声明在call()方法
    3.创建Callable接口实现类的对象
    4.将此Callable接口实现类的对象作为参数，传递到FutureTask类的构造器中，创建FutureTask对象
    5.将FutureTask对象作为对象，传递到Thread类的构造器中，创建Thread对象，并调用start()方法
    6.调用get()方法，获取创建Callable接口实现类的对象的call()方法中的返回值（如果没有返回值则不用获取，get()方法会阻塞）
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumberThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        FutureTask<Integer> futureTask = new FutureTask(numberThread);
        new Thread(futureTask).start();
        try {
            int sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}