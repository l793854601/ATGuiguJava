package senior.day09.java;

/*
    测试FileInputStream、FileOutputStream的使用
    结论：
    1.对于文本文件（.txt、.java、.c、.cpp）：使用字符流处理
    2.对于非文本文件（.jpg、.mp3、.mp4、.avi）：使用字节流处理
 */

import org.junit.Test;

import java.io.*;

public class FileInputOutputStreamTest {

    /*
        此处仅仅演示FileInputStream的使用
        使用字节流FileInputStream处理文本文件，是可能会出现乱码的
     */
    @Test
    public void testFileInputStream() {
        //  1.创建File对象
        File file = new File("Hello.txt");
        //  2.创建FileInputStream对象
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            //  3.读取数据
            StringBuffer sb = new StringBuffer();
            byte[] buffer = new byte[5];
            int length = -1;
            while ((length = fileInputStream.read(buffer)) != -1) {
                //  此处读取中文，有可能会被截断
                //  一个中文在utf-8下占用3个字节
                String subString = new String(buffer, 0, length);
                sb.append(subString);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭FileInputStream
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        实现对图片的复制（读入、写出）
     */
    @Test
    public void testFileInputOutputStream() {
        //  1.创建读入、写出的File对象
        File srcFile = new File("nfs21.jpeg");
        File destFile = new File("nfs21_copy.jpeg");

        //  2.创建输入流FileInputStream、输出流FileOutputStream
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //  3.复制（读入、写出）的过程
            byte[] buffer = new byte[5];
            int length = -1;
            while ((length = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭输入流FileInputStream、输出流FileOutputStream
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        使用FileInputStream、FileOutputStream实现指定路径下文件的复制
     */
    public void copyFile(String srcPath, String destPath) {
        //  1.创建读入、写出的File对象
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        //  2.创建输入流FileInputStream、输出流FileOutputStream
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //  3.复制（读入、写出）的过程
            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭输入流FileInputStream、输出流FileOutputStream
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        测试复制文件操作
        复制文件的时间，与文件大小、read()、write()中传入的byte数组的长度有关
        文件越小、byte数组长度越大，则花费的时间越少
     */
    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();

        String srcPath = "Java编程思想(第4版).pdf";
        String destPath = "Java编程思想(第4版)_copy.pdf";
        copyFile(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));  //  52718毫秒
    }
}

