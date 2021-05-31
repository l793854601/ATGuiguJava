package basic.day12.exer2;

/*
    写一个用户城西测试Account类，在用户程序中：
    创建一个账号为1122，余额为20000，年利率为4.5%的Account对象
    使用withdraw方法提款30000，并打印余额
    使用withdraw方法提款2500
    使用deposit方法存款3000，然后打印余额和月利率
 */

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000, 0.045);
        account.withdraw(30000);
        account.showBalance();

        account.withdraw(2500);

        account.deposit(3000);
        account.showBalance();
        account.showMonthlyInterest();
    }
}
