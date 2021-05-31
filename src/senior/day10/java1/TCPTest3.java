package senior.day10.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
    实现TCP的网络编程
    例3：客户端发送文件给服务端，服务端将收到的文件保存在本地，并返回发送成功给客户端，并关闭相应的连接。
 */
public class TCPTest3 {

    /*
        客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStreamReader isr = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9988);
            os = socket.getOutputStream();
            fis = new FileInputStream("nfs21.jpeg");

            byte[] writeBuffer = new byte[20];
            int length = -1;
            while ((length = fis.read(writeBuffer)) != -1) {
                os.write(writeBuffer, 0, length);
            }

            //  关闭数据的输出，如果不关闭，则服务端会一直卡在while循环读取火车
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            isr = new InputStreamReader(is);
            char[] readBuffer = new char[20];
            StringBuilder sb = new StringBuilder();
            while ((length = isr.read(readBuffer)) != -1) {
                sb.append(readBuffer, 0, length);
            }

            String string = sb.toString();
            System.out.println(string);

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
            if (isr != null) {
                try {
                    isr.close();
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
        OutputStream os = null;
        FileOutputStream fos = null;

        try {
            serverSocket = new ServerSocket(9988);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream("nfs21_from_client1.jpeg");

            byte[] buffer = new byte[20];
            int length = -1;

            while ((length = is.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

            os = socket.getOutputStream();
            os.write("AAAA已收到文件嘿嘿嘿嘿嘿12".getBytes());

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
            if (os != null) {
                try {
                    os.close();
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
