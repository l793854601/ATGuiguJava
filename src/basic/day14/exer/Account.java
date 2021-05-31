package basic.day14.exer;

/*
    编写一个类，竖线银行账户的概念，包含的属性有：
    "账号"、"密码"、"存款余额"、"利率"、"最小余额"
    定义封装浙西属性的方法，账号要自动生成

 */

public class Account {
    //  账号
    private int id;
    //  密码
    private String password = "000000";
    //  存款余额
    private double balance;
    //  利率
    private static double interestRate;
    //  最小余额
    private static double minBalance = 1.0;
    //  用于初始化账户
    private static int init = 1000;

    public Account() {
        id = init++;
    }

    public Account(String password, double balance) {
        this();
        this.password = password;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        Account.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
