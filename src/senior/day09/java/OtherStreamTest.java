package senior.day09.java;

/*
    其他流的使用
    1.标准的输入、输出流
    2.打印流
    3.数据流
 */

import org.junit.Test;

import java.io.*;

public class OtherStreamTest {

    /*
        1.标准的输入、输出流

        1.1
        System.in：标准的输入流，默认从键盘输入
        System.out：标准的输出流，默认从控制台输出

        1.2
        System类的setIn(InputStream in)、setOut(PrintStream out)方法，重新指定输入、输出流

        1.3
        从键盘输入字符串，要求将读取到的整行字符串转换成大写输出，然后继续进行输入操作，直到当输入"e"或者"exit"时，退出程序

        方式1：使用Scanner实现
        方式2：使用System.in
     */
    public static void main(String[] args) {
        //  通过转换流，将输入字节流转换为输入字符流
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            while (true) {
                System.out.println("请输入字符串：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    System.exit(0);
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        2.打印流：PrintStream、PrintWriter
        2.1 提供了一系列重载的print()和println()
        2.2 练习
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("PrintStreamTest.txt");
            ps = new PrintStream(fos, true);
            if (ps != null) {
                System.setOut(ps);
            }

            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
        3.数据流：DataInputStream、DataOutputStream
        3.1 作用：用于读入、写出基本数据类型的变量或字符串
        3.2 演示：将内存中给的字符串、基本数据累心给的变量，写出到文件中
     */
    @Test
    public void test3() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("data.txt");
            dos = new DataOutputStream(fos);
            dos.writeUTF("TKM");
            dos.flush();    //  刷新操作，将内存中的数据写入文件
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        将文件中的基本数据类型变量和字符串读入到内存中
        注意：读入不同类型的数据的的顺序要与当初保存文件时写入的顺序保持一致，否则会抛出异常：java.lang.EOFException
     */
    @Test
    public void test4() {
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("data.txt");
            dis = new DataInputStream(fis);
            System.out.println("姓名：" + dis.readUTF());
            System.out.println("年龄：" + dis.readInt());
            System.out.println("是否男性：" + dis.readBoolean());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
