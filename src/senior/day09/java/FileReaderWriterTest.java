package senior.day09.java;

/*
    1.流的分类：
        按照数据单位：字节流（8bit）、字符流（16bit）
        按照数据的流向：输入流（输入到内存）、输出流（从内存输出）
        按照流的角色：节点流、处理流

    2.流的体系结构：
        抽象基类             节点流（或文件流）          缓冲流（属于处理流的一种）
        InputStream          FileInputStream            BufferedInputStream
        OutputStream         FileOutputStream           BufferedOutputStream
        Reader               FileReader                 BufferedReader
        Writer               FileWriter                 BufferedWriter
 */

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

    /*
        将Hello.txt文件内容读入程序中，并输入到控制台

        说明：
        1.read()的理解：返回读入的一个字符（ascii值），如果达到文件（流）末尾，则返回-1
        2.异常的处理：为了保证流的资源一定可以执行关闭操作，需要使用try-catch-finally处理
        3.读入的文件一定要存在，否则会抛出FileNotFoundException
     */
    @Test
    public void testFileReader() {
        //  1.实例化File对象，指明要操作的文件
        File file = new File("Hello.txt");  //  单元测试中，相对于当前module
        //  2.提供具体的流（FileReader）
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            //  3.数据的读入
            int data;
            //  read()：返回读入的一个字符（ascii值），如果达到文件（流）末尾，则返回-1
            while ((data = fileReader.read()) != -1) {
                char ch = (char) data;
                System.out.print(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.流的关闭操作（必须手动关闭）
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        对read()操作升级：使用read()的重载方法
     */
    @Test
    public void testFileReader1() {
        //  1.创建对应的File对象
        File file = new File("hi.txt");
        //  2.FileReader流的实例化
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            //  3.读入的操作（使用char[]缓冲）
            StringBuffer sb = new StringBuffer();
            char[] buffer = new char[5];
            int length = -1;
            //  read(char[] cbuf)：返回每次读入cbuf数组中字符的个数，如果达到文件（流）末尾，则返回-1
            //  注意：不能取char[]的length作为读取的字符长度
            while ((length = fileReader.read(buffer)) != -1) {
                //  方式1：遍历字符数组，读取每一个字符
//                for (int i = 0; i < length; i++) {
//                    System.out.print(buffer[i]);
//                }
//                System.out.println();
                //  方式2：将字符数组拼接为字符序列
                sb.append(buffer, 0, length);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.资源的关闭
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        从内存中写入数据到硬盘的文件中
        说明：
        1.输出操作，对应的File对象，
            如果不存在，在输出（write）的过程中，会自动创建
            如果存在，则根据FileWriter的构造方法中的append参数决定是覆盖文件还是追加文件
                     FileWriter(file, false) / FileWriter(file)：对原有文件覆盖
                     FileWriter(file, true)：不会覆盖文件，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() {
        //  1.创建File对象，指明写出到的对象
        File file = new File("file_write_test.txt");
//        if (file.exists()) {
//            file.delete();
//        }

        //  2.提供FileWriter的对象，用于数据的写出
        FileWriter fileWriter = null;
        try {
            //  append：true表示在文件末尾追加输出、false表示覆盖输出
            fileWriter = new FileWriter(file, false);
            //  3.写出的操作
            fileWriter.write("file_write_test: \n");
            fileWriter.write("I have a dream\n");
            fileWriter.write("You also have a dream\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.流资源的关闭
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        将文件读入到内存，再输出
     */
    @Test
    public void testFileReaderWriter() {
        //  1.创建File类的对象，指明读入和写出的对象
        File srcFile = new File("src_hello2.txt");
        File destFile = new File("dest_hello2.txt");

        //  注意：FileReader、FileWriter不能处理非字节文件（二者为字符流，专门处理字符的）
//        File srcFile = new File("nfs21.jpeg");
//        File destFile = new File("nfs21_copy.jpeg");

        //  2.创建输入流FileReader、输出流FileWriter
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(srcFile);
            fileWriter =new FileWriter(destFile);
            //  3.数据的读入和写出操作
            char[] buffer = new char[5];
            int length = -1;
            while ((length = fileReader.read(buffer)) != -1) {
                //  此处需要注意：读取的长度，是read()方法返回的长度
                fileWriter.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  4.关闭流资源，需要保证每个流都关闭
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
