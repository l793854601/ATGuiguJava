package senior.day02.java;

/*
    多线程的内存布局
    PC寄存器：每一个线程都有自己的PC寄存器
    Java虚拟机栈：每一个线程都有自己的Java虚拟机栈
    堆：多个线程共享堆
    方法区：多个线程共享方法区
    本地方法栈：每一个线程都有自己的本地方法栈

    因此，开启新线程，需要分配PC寄存器、Java虚拟机栈、本地方法栈等资源
 */

public class ThreadMemoryTest {
}
