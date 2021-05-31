package basic.day15.exer2;

/*
    MyDate类包含：
    private成员变量year、month、day
    toDateString()方法返回日期对应的字符串：yyyy年MM月dd日
 */

public class MyDate {
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

    public String toDateString() {
        return String.format("%04d年%02d月%02d日", year, month, day);
    }

    @Override
    public String toString() {
        return toDateString();
    }
}
