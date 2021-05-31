package senior.day09.java;

import org.junit.Test;

import java.io.*;

/*
    缓冲流的使用：
    1.缓冲流：
    BufferedInputStream
    BufferedOutputStream
    BufferedReader
    BufferedWriter

    2.作用：提高流的读取、写入的速度
        提高读写速度的原因：内部提供了一个缓冲区

    3.处理流：就是"套接"在已有的流（处理流、节点流）的基础之上
 */
public class BufferedTest {

    /*
        使用BufferedInputStream、BufferedOutputStream实现非文本文件复制
     */
    @Test
    public void bufferedStrreamTest() {
        //  1.创建File对象
        File srcFile = new File("Java编程思想(第4版).pdf");
        File destFile = new File("Java编程思想(第4版)_copy1.pdf");

        //  2.创建流对象
        //  2.1 创建节点流FileInputStream、FileOutputStream
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //  2.2 创建处理流BufferedInputStream、BufferedOutputStream
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //  3.读取、写入
            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭流，要求：先关闭外层的流（处理流），再关闭内层的流（节点流）
            //  在关闭处理流时，节点流会自动关闭，因此只需手动关闭节点流即可
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }

            //  无需手动关闭节点流
//            //  4.1 先关闭处理流
//            if (bufferedInputStream != null) {
//                try {
//                    bufferedInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (bufferedOutputStream != null) {
//                try {
//                    bufferedOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            //  4.2 再关闭节点流
//            if (fileInputStream != null) {
//                try {
//                    fileInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fileOutputStream != null) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    /*
        使用BufferedInputStream、BufferedOutputStream实现指定路径下文件的复制
     */
    public void copyFileWithBuffered(String srcPath, String destPath) {
        //  1.创建File对象
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        //  2.创建流对象
        //  2.1 创建节点流FileInputStream、FileOutputStream
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //  2.2 创建处理流BufferedInputStream、BufferedOutputStream
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //  3.读取、写入
            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭流，要求：先关闭外层的流（处理流），再关闭内层的流（节点流）
            //  在关闭处理流时，内层流会自动关闭，因此只需手动关闭外层流即可
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        测试复制文件操作
    */
    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();

        String srcPath = "Java编程思想(第4版).pdf";
        String destPath = "Java编程思想(第4版)_copy.pdf";
        copyFileWithBuffered(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));  //  624毫秒
    }

    /*
        使用BufferedReader、BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderWriter() {
        //  1.创建File
        File srcFile = new File("Hello.txt");
        File destFile = new File("Hello_copy1.txt");

        //  2.创建流
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            bufferedWriter = new BufferedWriter(new FileWriter(destFile));
            //  3.读写操作
            //  方式1：使用char[]
//            char[] buffer = new char[10];
//            int length = -1;
//            while ((length = bufferedReader.read(buffer)) != -1) {
//                bufferedWriter.write(buffer, 0, length);
//            }
            //  方式2：使用String
            String string = null;
            //  readLine()：如果源字符文件中包含换行符，则返回的String不会包含换行符，需要手动添加
            while ((string = bufferedReader.readLine()) != null) {
                //  方式1：手动拼接换行符
//                bufferedWriter.write(string);
//                bufferedWriter.write(System.lineSeparator());
                //  方式2：使用newLine()方法
                bufferedWriter.write(string);
                bufferedWriter.newLine();   //  内部也是调用write()添加换行符
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭流
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
