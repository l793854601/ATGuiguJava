package basic.day10.exer3;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    //  使用toString方法显示打印信息
    @Override
    public String toString() {
        return "Customer ["  + getFirstName() + ", " + getLastName() + "] has a account: id is " + account.getId()
                + ", annualInterestRate is " + account.getAnnualInterestRate() * 100 + "%"
                + ", balance is " + account.getBalance();
    }
}
