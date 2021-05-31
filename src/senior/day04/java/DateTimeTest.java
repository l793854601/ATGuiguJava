package senior.day04.java;

/*
    JDK8之前的日期时间的API测试
    1.System.currentTimeMillis();
    2.java.util.Date类
    3.SimpleDateFormat
    4.Calendar

    SimpleDateFormat的使用：SimpleDateFormat对Date类的格式化和解析
    1.两个操作：
        格式化：日期（Date） -> 字符串（String）
        解析：字符串（String）-> 日期（Date）

    2.SimpleDateFormat实例化：

 */

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeTest {

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        //  格式化
        Date date = new Date();
        String dateString = dateFormat.format(date);
        System.out.println(dateString);

        //  解析
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateString = "2020-03-20 19:20:00"; //  要求字符串必须符合pattern格式，否则会抛出ParseException
        date = dateFormat.parse(dateString);
        System.out.println(date);
    }

    /*
        练习一：将"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void test2() throws ParseException {
        String dateString = "2020-09-08";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }

    /*
        Calendar日历类（抽象类）的使用
     */
    @Test
    public void testCalendar() {
        //  1.实例化
        //  方式1
//        Calendar calendar = new GregorianCalendar();
        //  方式2
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //  2.常用方法
        //  get()
        //  本月的第几天（从1日开始算）
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //  本周的第几天（从周日开始算）
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        //  本年的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //  set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //  add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //  getTime()
        Date date = calendar.getTime();
        System.out.println(date);

        //  setTime()
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
    }
}