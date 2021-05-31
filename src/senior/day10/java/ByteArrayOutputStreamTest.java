package senior.day10.java;

import org.junit.Test;

import java.io.*;

/*
    ByteArrayOutputStream的使用
 */
public class ByteArrayOutputStreamTest {

    @Test
    public void test1() {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("Hello_copy1.txt");
            String string = readStringFromPutputStream(fileInputStream);
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readStringFromPutputStream(FileInputStream fileInputStream) {
        ByteArrayOutputStream baos = null;
        String result = "";
        try {
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int length = -1;
            while ((length = fileInputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            result = baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}











