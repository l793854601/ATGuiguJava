package senior.day03.java;

/*
    String的常用方法
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

public class StringMethodTest {

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        //  返回字符串的长度
        System.out.println(s1.length());    //  10
        //  返回指定索引位置的字符，注意不要越界
        System.out.println(s1.charAt(0));   //  'H'
        //  判断是否为空字符串
        System.out.println(s1.isEmpty());   //  false
        //  使用默认语言环境，将字符串中的所有字符转换为小写（字符串本身不会变）
        System.out.println(s1.toLowerCase());   //  helloworld
        //  使用默认语言环境，将字符串中的所有字符转换为大写（字符串本身不会变）
        System.out.println(s1.toUpperCase());   //  HELLOWORLD

        String s3 = " h e ll o  worl d ";
        //  除去字符串中首尾出现的一个或多个空格（字符串本身不会变）
        System.out.println(s3.trim());  //  h e ll o  worl d
    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = s1.toLowerCase();
        //  比较两个字符串内容是否相等
        System.out.println(s1.equals(s2));  //  false
        //  忽略大小写，比较两个字符串内容是否相等
        System.out.println(s1.equalsIgnoreCase(s2));    //  true

        String s3 = "abc";
        //  将指定字符串连接到此字符串的结尾，等价于+
        System.out.println(s3.concat("def"));   //  abcdef

        String s5 = "abc";
        String s6 = new String("abd");
        //  比较两个字符串的大小（String实现了Comparable接口）
        System.out.println(s5.compareTo(s6));   //  -1

        String s7 = "北京尚硅谷教育";
        //  返回一个从beginIndex开始到末尾截取的新字符串，截取范围为[beginIndex, length())，注意不要越界（字符串本身不会变）
        System.out.println(s7.substring(2));    //  尚硅谷教育
        //  返回一个从beginIndex开始到endIndex截取的新字符串，截取范围为[beginIndex, endIndex)，注意不要越界（字符串本身不会变）
        System.out.println(s7.substring(2, 5)); //  尚硅谷 
    }

    @Test
    public void test3() {
        String s1 = "helloworld";
        //  判断此字符串是否以指定的字符串为结尾
        System.out.println(s1.endsWith("ld"));  //  true
        //  判断此字符串是否以指定的字符串为开头
        System.out.println(s1.startsWith("hel"));   //  true
        //  判断此字符串从指定索引开始的子字符串是否以指定前缀为开头
        System.out.println(s1.startsWith("ll", 2));  //  true;
        //  判断此字符串是否包含指定的char值序列（CharSequence）
        System.out.println(s1.contains("wo"));  //  true
        //  返回指定子字符串在此字符串中第一次出现的索引（如果不存在，则返回-1）
        System.out.println(s1.indexOf("lo"));   //  5
        //  返回指定子字符串在此字符串中第一次出现的索引，从fromIndex开始搜索（如果不存在，则返回-1）
        System.out.println(s1.indexOf("lo", 5));    //  -1

        String s2 = "hellorworld";
        //  返回指定子字符串在此字符串中最后一次出现的索引（如果不存在，则返回-1）
        System.out.println(s2.lastIndexOf("or"));   //  7
        //  返回指定子字符串在此字符串中第一次出现的索引，从fromIndex开始反向搜索（如果不存在，则返回-1）
        System.out.println(s2.lastIndexOf("or", 6));    //  4

        /*
            什么情况下，indexOf(str)与lastIndexOf(str)返回相同值？
            1.存在唯一的str
            2.不存在str（-1）
         */
    }

    @Test
    public void test4() {
        String s1 = "北京尚硅谷教育北京总部";
        //  将此字符串中的oldChar替换为newChar，并返回新字符串（原字符串不会被修改）
        System.out.println(s1.replace('北','南'));    //  南京尚硅谷教育南京总部
        //  将此字符串中的target字符序列替换为replacement字符序列，并返回新字符串（原字符串不会被修改）
        System.out.println(s1.replace("北京", "上海")); //  上海尚硅谷教育上海总部

        String str = "12hello34world5java7891mysql1456";
        //  使用正则表达式匹配，将此字符串中满足的子串，替换为replacement，并返回新字符串（原字符串不会被修改）
        String string = str.replaceAll("\\d+",","); //  ,hello,world,java,mysql,
        System.out.println(string);

        String phone = "025-4534289";
        //  判断此字符串是否匹配正则表达式
        boolean match = phone.matches("025-\\d{7,8}");  //  true
        System.out.println(match);

        String hw = "hello!world!java";
        //  使用正则表达式，将字符串分割为String数组
        String[] strs = hw.split("\\!");
        System.out.println(Arrays.toString(strs));
    }
}
