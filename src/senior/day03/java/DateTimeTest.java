package senior.day03.java;

/*
    JDK8之前日期和时间的API测试

    System.currentTimeMillis();
    返回当前时间到1970年1月1日0时0分0秒之间以毫秒为单位的时间差
    也叫时间戳

    java.util.Date类
    1.两个构造器
        Date()：创建一个当前时间的Date对象
        Date(long date)：根据时间戳，创建一个对应的Date对象
    2.两个方法
        toString()：显示当前的年、月、日、时、分、秒、时区
        getTime()：返回当前Date对象对应的时间戳

    java.sql.Date类：对应着数据库中的日期类型的变量
 */

import org.junit.Test;

import java.util.Date;

public class DateTimeTest {

    @Test
    public void test1() {
        //  返回当前时间到1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //  也叫时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2() {
        Date date1 = new Date();
        System.out.println(date1);
        System.out.println(date1.getTime());

        Date date2 = new Date(1616252014875L);
        System.out.println(date2);
    }
}
