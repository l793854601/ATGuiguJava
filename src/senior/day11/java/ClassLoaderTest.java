package senior.day11.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
    了解类的加载器
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        //  对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader1);

        //  调用系统类加载器的getParent()，获取扩展类加载器（jdk9之后为平台类加载器）
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        //  调用扩展类加载器的getParent()，无法获取引导类加载器
        //  引导类加载器主要负责加载Java的核心类库，是无法加载自定义类的
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);

        //  String的类加载器就是引导类加载器，无法获取
        ClassLoader classLoader4 = String.class.getClassLoader();
        System.out.println(classLoader4);
    }

    /*
        Properties：用来读取配置文件
     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //  读取配置文件的方式1
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);
        //  读取配置文件的方式2
        //  注意：此方式下，配置文件默认识别为：当前module的src下，此处仅作为演示
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
//        pros.load(is);

        System.out.println(pros.getProperty("user"));
        System.out.println(pros.getProperty("password"));
        System.out.println(pros.getProperty("gender"));
    }
}
