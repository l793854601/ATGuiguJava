package senior.day09.exer;

/*
    图片的加密、解密操作
 */

import org.junit.Test;

import java.io.*;

public class PicTest {

    /*
        图片的加密
     */
    @Test
    public void test1() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("nfs21.jpeg");
            fileOutputStream = new FileOutputStream("nfs21_encryption.jpeg");
            byte[] buffer = new byte[20];
            int length = -1;
            while ((length = fileInputStream.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fileOutputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        图片的解密
     */
    @Test
    public void test2() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("nfs21_encryption.jpeg");
            fileOutputStream = new FileOutputStream("nfs21_decrypt.jpeg");
            byte[] buffer = new byte[20];
            int length = -1;
            while ((length = fileInputStream.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fileOutputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
}
