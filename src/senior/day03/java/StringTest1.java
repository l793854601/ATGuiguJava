package senior.day03.java;

/*
    涉及到String类与其他结构之间的转换

    String与基本数据类型、包装类之间的转换
    String - > 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 -> String：调用String重载的valueOf(xxx)方法，或者直接使用连接符+""

    String与char[]之间的转换
    String - > char[]：调用String的toCharArray()方法
    char[] - > String：调用String的构造器，或者调用String重载的valueOf(char[])方法

    String与byte[]之间的转换
    编码：String - > byte[]：调用String的getBytes()方法
    解码：byte[] - > String：调用String的构造器

    编码：字符串 -> 字节（看得懂 -> 看不懂的二进制数据）
    解码：字节 -> 字符串（看不懂的二进制数据 -> 看得懂）
    说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
 */

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringTest1 {
    @Test
    public void test1() {
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);

        String str2 = String.valueOf(num);
        System.out.println(str2);

        String str3 = num + "";
        System.out.println(str3);
    }

    @Test
    public void test2() {
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        System.out.println(Arrays.toString(chars));

        String str2 = new String(chars);
        System.out.println(str2);

        String str3 = String.valueOf(chars);
        System.out.println(str3);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        //  使用默认的字符集进行转换
        byte[] bytes1 = str1.getBytes();
        System.out.println(Arrays.toString(bytes1));
        //  使用gbk字符集进行转换
        byte[] bytes2 = str1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes2));

        String str2 = new String(bytes1);
        System.out.println(str2);

        String str3 = new String(bytes2, "gbk");
        System.out.println(str3);

        String str4 = new String(bytes2);
        System.out.println(str4);   //  出现乱码的原因：编码集与解码集不一致
    }
}
