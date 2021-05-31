package senior.day04.java;

/*
    其他常用类的使用
    1.System
    2.Math
    3.BigInteger、BigDecimal
 */

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class OtherClassTest {

    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java version: " + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java home: " + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os name: " + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os version: " + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user name: " + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user home: " + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user dir: " + userDir);
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal(12435.351);
        BigDecimal bd2 = new BigDecimal(11);

        System.out.println(bi);
        System.out.println(bd);
        System.out.println(bd2);

//        System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, RoundingMode.HALF_UP));
        System.out.println(bd.divide(bd2, 15, RoundingMode.HALF_UP));
    }
}
