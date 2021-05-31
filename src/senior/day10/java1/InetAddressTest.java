package senior.day10.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    1.网络编程中有两个主要的问题：
        1）如何准确地定位网络上一台或多台主机，定位主机上特定的应用
        2）找到注解后如何可靠高效地进行数据传输

    2.网络编程中的两个要素：
        1）IP和端口号
        2）提供网络通信协议：
            OSI参考模型：应用层、表示层、会话层、传输层、网络层、数据链路层、物理层
            TCP/IP参考模型：应用层、传输层、网络层、物理+数据链路层

    3.通信要素一：IP和端口号
        1）IP：唯一的表示Internet上的计算机（通信实体）
        2）在Java中，使用InetAddress类代表IP
        3）IP的分类：
            分类方式1：IPV4、IPV6
            分类方式2：万维网、局域网
        4）域名：www.baidu.com、www.bilibili.com、www.apple.com
        5）本地回路地址：127.0.0.1，对应者：localhost
        6）创建InetAddress常用方法：
            getByName(String host)：通过域名、IP创建
            getLocalHost()：获取本机地址
           两个常用方法：
            getHostName()：获取域名
            getHostAddress()： 获取IP
        7）端口号：标识正在计算机上运行的进程（进程）
           要求：不同的进程要有不同的端口号
           范围：0~65535的一个16位的整数
        8）端口号与IP地址的组合得出一个网络套接字：Socket
 */
public class InetAddressTest {

    public static void main(String[] args) {
        //  创建InetAddress对象
        try {
            //  使用IP创建InetAddress
            InetAddress address1 = InetAddress.getByName("192.168.0.11");
            System.out.println(address1);

            //  使用域名创建InetAddress
            InetAddress address2 = InetAddress.getByName("www.baidu.com");
            System.out.println(address2);

            //  获取本机地址方式1
            InetAddress address3 = InetAddress.getByName("127.0.0.1");
            System.out.println(address3);

            //  获取本机地址方式2
            InetAddress address4 = InetAddress.getByName("localhost");
            System.out.println(address4);

            //  获取本机地址方式3
            InetAddress address5 = InetAddress.getLocalHost();
            System.out.println(address5);

            //  获取域名、IP
            System.out.println(address2.getHostName());
            System.out.println(address2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}









