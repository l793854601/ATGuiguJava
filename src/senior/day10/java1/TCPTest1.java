package senior.day10.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
    实现TCP的网络编程
    例1：客户端发送信息给服务端，服务端将收到的数据显示在控制台上
 */
public class TCPTest1 {

    /*
        客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //  1.创建Socket对象，并指明服务端的IP与端口号
            InetAddress inet = InetAddress.getByName("192.168.0.11");
            socket = new Socket(inet, 8899);
            //  2.获取Socket对象的输出流，用于输出（发送）数据
            os = socket.getOutputStream();
            //  3.写出数据
            os.write("Hello".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.资源关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        服务端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        Socket socket = null;

        try {
            //  1.创建ServerSocket对象，并指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //  2.调用accept()方法，表示接收来自客户端的Socket对象
            socket = serverSocket.accept();
            //  3.获取客户端Socket对象的输入流
            is = socket.getInputStream();
            //  4.读取输入流中的数据（来自客户端的数据）
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = (is.read(buffer))) != -1) {
                baos.write(buffer, 0, length);
            }

            System.out.println(baos.toString());
            System.out.println("收到来自于：" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  5.资源关闭
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
