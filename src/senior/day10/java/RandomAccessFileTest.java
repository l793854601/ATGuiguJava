package senior.day10.java;

import org.junit.Test;

import java.io.*;

/*
    RandomAccessFile的使用
    1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput、DataOutput接口

    2.RandomAccessFile既可以作为输入流，又可以作为一个输出流

    3.RandomAccessFile作为输出流时：
        如果写出到的文件不存在，则在执行过中自动创建
        如果写出到的文件存在，则会对原有文件内容进行覆盖（默认情况下，为从头覆盖）

    4.如果想实现使用RandomAccessFile实现插入数据，则需要相关操作，具体看test3()方法
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        /*
            创建RandomAccessFile实例，需要指定一个mode参数，改参数指定了RandomAccessFile的访问模式
            r：以只读方式打开
            rw：打开以便读取和写入
            rwd：打开以便读取和写入，同步文件内容的更新
            rws：打开以便读取和写入，同步文件内容和元数据的更新
         */
        File srcFile = null;
        File destFile = null;
        RandomAccessFile input = null;
        RandomAccessFile output = null;
        try {
            srcFile = new File("nfs21.jpeg");
            destFile = new File("nfs21_copyWithRandomAccessFile.jpeg");
            input = new RandomAccessFile(srcFile, "r");    //  mode传入r，表示input可作为一个输入流
            output = new RandomAccessFile(destFile, "rw");   //  mode传入rw，表示output可作为一个输出流

            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = input.read(buffer)) != -1) {
                output.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        File srcFile = null;
        RandomAccessFile output = null;
        try {
            srcFile = new File("Hello3.txt");
            output = new RandomAccessFile(srcFile, "rw");
            String string = "123";
            output.seek(3); //  将指针调到角标为3（第4个字符开始）的位置
            output.writeBytes(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        使用RandomAccessFile实现数据的插入效果（配合使用StringBuilder）
     */
    @Test
    public void test3() {
        File srcFile = null;
        RandomAccessFile output = null;
        try {
            srcFile = new File("Hello3.txt");
            output = new RandomAccessFile(srcFile, "rw");
            //  将指针移动到角标为3的位置
            output.seek(3);
            //  保存指针3后面的所有数据，到StringBuilder中
            StringBuilder sb = new StringBuilder((int) (srcFile.length())); //  防止StringBuilder扩容
            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = output.read(buffer)) != -1) {
                sb.append(new String(buffer), 0, length);
            }
            //  将指针移动到角标为3的位置
            output.seek(3);
            //  插入数据
            output.writeBytes("123");
            //  将StringBuilder中的数据继续写入
            output.write(sb.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        使用RandomAccessFile实现数据的插入效果（配合使用ByteArrayOutputStream）
     */
    @Test
    public void test4() {
        File srcFile = new File("Hello3.txt");
        RandomAccessFile output = null;
        ByteArrayOutputStream bufferStream = null;
        try {
            output = new RandomAccessFile(srcFile, "rw");
            output.seek(3);

            bufferStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = output.read(buffer)) != -1) {
                bufferStream.write(buffer, 0, length);
            }

            String string = bufferStream.toString();
            output.seek(3);
            output.writeBytes("123");
            output.writeBytes(string);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferStream != null) {
                try {
                    bufferStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}











