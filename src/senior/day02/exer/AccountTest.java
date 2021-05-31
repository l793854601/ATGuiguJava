package senior.day02.exer;

/*
    银行有一个账户。
    有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int amt) {
        if (amt > 0) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance += amt;
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {

    private Account account;

    private static Lock lock = new ReentrantLock(true);

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                account.deposit(1000);
            } finally {
                lock.unlock();
            }
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);

        Customer c1 = new Customer(account);
        c1.setName("甲");

        Customer c2 = new Customer(account);
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
