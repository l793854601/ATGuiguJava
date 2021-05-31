package senior.day02.java;

/*
    线程的生命周期：
    1.新建
    2.就绪
    3.运行
    4.阻塞
    5.死亡

    新建：创建一个Thread对象
    新建 -> 就绪：调用start()方法
    就绪 -> 运行：获取CPU执行权
    运行 -> 就绪：失去CPU执行权，或调用yield()方法主动让出CPU执行权
    运行 -> 死亡：线程正常执行完毕，或调用stop()方法强制结束线程，或出现异常且未处理
    运行 -> 阻塞：sleep(long time)、join()、等待同步锁、wait()、suspend()
    阻塞 -> 就绪：sleep()时间到、join()结束、获取了同步锁、notify()、notifyAll()、resume()
 */

public class  ThreadStateTest {
}
