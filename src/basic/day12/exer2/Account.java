package basic.day12.exer2;

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

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * 返回月利率
     * @return
     */
    public double getMonthlyInterest() {
        return annualInterestRate / 12;
    }

    /**
     * 取钱
     * @param amount
     */
    public void withdraw(double amount) {
        BigDecimal balanceValue = new BigDecimal(balance);
        BigDecimal amountValue = new BigDecimal(amount);
        if (balanceValue.compareTo(amountValue) < 0) {
            System.out.println("余额不足");
            return;
        }
        balance = balanceValue.subtract(amountValue).doubleValue();
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
        }
    }

    public void showBalance() {
        System.out.println("您的账户余额为：" + balance);
    }

    public void showMonthlyInterest() {
        System.out.println("月利率为：" + getMonthlyInterest() * 100 + "%");
    }
}
