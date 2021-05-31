package basic.day15.exer2;

/*
    定义一个Employee类，该类包含：
    private成员变量name、number、birthday，其中birthday为MyDate的对象
    abstract方法earnings()
    toString()方法输出name、number、birthday
 */

public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee() {

    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday;
    }
}
