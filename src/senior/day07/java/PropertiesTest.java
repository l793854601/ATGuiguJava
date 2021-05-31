package senior.day07.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
    Properties：常用来处理配置文件，key、value都是String类型
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        pros.load(fileInputStream);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name: " + name);
        System.out.println("password: " + password);
        //  用完要关闭
        fileInputStream.close();
    }
}
