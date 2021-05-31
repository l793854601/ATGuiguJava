package senior.day10.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/*
    UDP协议的网络编程
 */
public class UDPTest {

    /*
        发送端
     */
    @Test
    public void send() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String string = "我是UDP方式发送的导弹";
            byte[] data = string.getBytes();
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(
                    data, 0, data.length, inet, 9909);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    /*
        接收端
     */
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9909);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
