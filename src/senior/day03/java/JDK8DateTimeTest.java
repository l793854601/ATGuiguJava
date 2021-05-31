package senior.day03.java;

/*
    JDK8中日期时间API测试

    Calendar、Date的问题：
    可变性：像日期和时间这样的类应该是不可变的
    偏移性：Date中的年份是从1900开始的，而月份是从0开始
    格式化：格式化只对Date有用，Calendar则不行
    此外，它们也不是线程安全的；不能处理闰秒等
 */

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class JDK8DateTimeTest {
    @Test
    public void testDate() {
        /*
            As of JDK version 1.1,
            replaced by Calendar.set(year + 1900, month, date) or
            GregorianCalendar(year + 1900, month, date).
            year传入2020，相当于2020+1990年。month传入9，相当于10月
         */
        Date date1 = new Date(2020, 9, 8);
        System.out.println(date1);  //  Fri Oct 08 00:00:00 CST 3920
    }

    /*
        LocalDate、LocalTime、LocalDateTime的使用
     */
    @Test
    public void test1() {
        //  now()：获取当前时间、日期、日期+时间
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        //  of()：设置指定的年月日时分秒，是没有Date中的偏移量的
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 3, 22, 21, 50, 30);
        System.out.println(localDateTime1);

        //  get(xxx)：获取相关属性
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        //  with(xxx)：设置相关属性，并生成一个新的对象，体现了LocalDate的不可变性
        LocalDateTime localDateTime2 = localDateTime
                .withYear(2020)
                .withMonth(3)
                .withDayOfMonth(22)
                .withHour(20)
                .withMinute(30)
                .withSecond(0)
                .withNano(0);
        System.out.println(localDateTime2);

        //  plusXxx()：向后增加时间，并返回新的对象
        LocalDateTime localDateTime3 = localDateTime
                .plusYears(1)
                .plusMonths(3);
        System.out.println(localDateTime3);

        //  minusXxx()：向前减少时间，并返回新的对象
        LocalDateTime localDateTime4 = localDateTime
                .minusYears(1)
                .minusMonths(1);
        System.out.println(localDateTime4);

        //  将日期对象转换为时间戳（因为我们再东八区，因此需要加上偏移量）
        System.out.println(localDateTime.toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }


    /*
        Instant的使用
        类似于java.util.Date类
     */
    @Test
    public void test2() {
        //  返回的是本初子午线的时间，而我们在东八区，因此会少8个小时
        Instant instant = Instant.now();
        System.out.println(instant);    //  2021-03-22T14:15:00.343654Z

        //  加上8个小时的偏移量，就是我们当前的时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //  2021-03-22T22:15:00.343654+08:00

        //  获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数（13位时间戳）
        System.out.println(instant.toEpochMilli());

        //  ofEpochMilli(xxx)：使用时间戳创建Instant对象（返回的是本初子午线的时间）
        Instant instant1 = Instant.ofEpochMilli(1616423175000L);
        System.out.println(instant1);
    }

    /*
        DateTimeFormatter：格式化或解析日期、时间
        类似于SimpleDateFormatter
     */
    @Test
    public void test3() {
        //  方式1：预定义的标准格式，如ISO_LOCAL_DATE_TIME、ISO_LOCAL_DATE、ISO_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //  格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String format = formatter.format(localDateTime);
        System.out.println(format);
        //  解析
        TemporalAccessor parse = formatter.parse("2021-03-22T22:35:11.805065");
        System.out.println(parse);

        //  方式2：本地化相关的格式，如ofLocalizedDateTime()
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                .withZone(ZoneId.systemDefault());  //  jdk11之后需要补上时区，否则会抛出异常java.time.DateTimeException
        String format1 = formatter1.format(localDateTime);
        System.out.println(format1);

        //  方式3：
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format2 = formatter2.format(localDateTime);
        System.out.println(format2);
        TemporalAccessor parse1 = formatter2.parse("2021-03-22 22:47:32");
        System.out.println(parse1);
    }
}
