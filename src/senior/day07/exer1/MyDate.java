package senior.day07.exer1;

/*
    MyDate类包含：
    private成员变量year、month、day，并为每一个成员变量定义getter、setter方法
 */

import java.time.LocalDate;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {

    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        LocalDate localDate1 = LocalDate.of(year, month, day);
        LocalDate localDate2 = LocalDate.of(o.year, o.month, o.day);
        return localDate1.compareTo(localDate2);
    }
}

