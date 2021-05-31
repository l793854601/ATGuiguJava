package senior.day10.java1;

import java.net.MalformedURLException;
import java.net.URL;

/*
    URL网络编程
    1.URL：同意资源定位符，对应者互联网上的某一资源地址
    2.格式：
        http://localhost:8080/example/beauty.jpg?username=Tom
        协议   主机名     端口号 资源地址         参数列表
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/example/beauty.jpg?username=Tom");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
