package basic.day10.exer3;

import java.math.BigDecimal;

public class Account {
    /**
     * 账号
     */
    private int id;

    /**
     * 余额
     */
    private double balance;

    /**
     * 年利率
     */
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * 取钱
     * @param amount
     */
    public void withdraw(double amount) {
        //  浮点数进行加减乘除运算、比较大小时，建议使用BigDecimal
        BigDecimal balanceValue = new BigDecimal(balance);
        BigDecimal amountValue = new BigDecimal(amount);
        if (balanceValue.compareTo(amountValue) < 0) {
            System.out.println("余额不足，取款失败！");
            return;
        }
        balance = balanceValue.subtract(amountValue).doubleValue();
        System.out.println("成功取出：" + amount);
    }

    /**
     * 存钱
     * @param amount
     */
    public void deposit(double amount) {
        BigDecimal balanceValue = new BigDecimal(balance);
        if (balanceValue.compareTo(new BigDecimal(0)) > 0) {
            BigDecimal amountValue = new BigDecimal(amount);
            balance = balanceValue.add(amountValue).doubleValue();
            System.out.println("成功存入：" + amount);
        }
    }
}
