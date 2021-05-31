package basic.day13.exer2;

class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof MyDate) {
            MyDate date = (MyDate) o;
            return year == date.year
                    && month == date.month
                    && day == date.day;
        }
        return false;
    }
}

public class MyDateTest {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(21, 1, 2020);
        MyDate d2 = new MyDate(21, 2, 2020);
        MyDate d3 = new MyDate(21, 1, 2020);
        MyDate d4 = null;
        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d3));
        System.out.println(d1.equals(d4));
    }
}
