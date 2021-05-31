package senior.day09.java;

/*
    转换流的使用：
    1.转换流：属于字符流，也属于处理流
        InputStreamReader：输入字节流 -> 输入字符流
        OutputStreamWriter：输出字符流 -> 输出字节流

    2.作用：提供字节流、字符流之间的转换

    3.解码：字节、字符数组 -> 字符串
      编码：字符串 -> 字节、字符数组

    4.字符集
        ASCII：美国标准信息交换码，用一个字节的7位可以表示
        ISO8895-1：拉丁码表、欧洲码表，用一个字节的8位表示
        GB2312：中国的中文编码表，最多两个字节编码所有字符
        GBK：中国的中文编码表升级，融合了更多的中文文字符号，最多两个字节编码所有字符
        Unicode：国际标准码，融合了目前人类使用的所有字符，为每一个字符分配唯一的字符码
        UTF-8：变长的编码方式，可用1-4个字节来表示一个字符
 */

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {

    /*
        InputStreamReader的使用：
        实现了从输入字节流转换为输入字符流的转换
     */
    @Test
    public void test1() {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
            fileInputStream = new FileInputStream("Hello.txt");
//            inputStreamReader = new InputStreamReader(fileInputStream); //  使用系统默认的字符集
            //  charsetName：字符集，根据源文件保存时使用的字符集决定
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            StringBuffer sb = new StringBuffer();
            char[] buffer = new char[5];
            int length = -1;
            while ((length = inputStreamReader.read(buffer)) != -1) {
                sb.append(buffer, 0, length);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        综合使用InputStreamReader、OutputStreamWriter
        将以UTF-8编码的Hello.txt文件，转换为以GBK编码的文件，并保存为Hello_gbk.txt
     */
    @Test
    public void test2() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            fileInputStream = new FileInputStream("Hello.txt");
            fileOutputStream = new FileOutputStream("Hello_gbk.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");

            char[] buffer = new char[10];
            int length = -1;
            while ((length = inputStreamReader.read(buffer)) != -1) {
                outputStreamWriter.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
