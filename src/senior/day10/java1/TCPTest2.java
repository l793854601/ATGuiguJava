package senior.day10.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
    实现TCP的网络编程
    例2：客户端发送文件给服务端，服务端将收到的文件保存在本地
 */
public class TCPTest2 {

    /*
        客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            os = socket.getOutputStream();
            fis = new FileInputStream("nfs21.jpeg");

            byte[] buffer = new byte[20];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
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
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            File destFile = new File("nfs21_from_client.jpeg");
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[20];
            int length = -1;
            while ((length = is.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

            System.out.println("收到来自：" + socket.getInetAddress().getHostAddress() + "的消息");
            System.out.println("文件大小：" + destFile.length());
            System.out.println("文件名：" + destFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
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
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
