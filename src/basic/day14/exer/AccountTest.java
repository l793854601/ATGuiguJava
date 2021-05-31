package basic.day14.exer;

public class AccountTest {
    public static void main(String[] args) {
        Account acc1 = new Account();
        Account acc2 = new Account("qwerty", 200.0);
        Account.setInterestRate(0.012);
        Account.setMinBalance(100);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc1.getInterestRate());
        System.out.println(acc1.getMinBalance());
    }
}
