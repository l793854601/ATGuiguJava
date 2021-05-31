package basic.day15.java;

//  一下单例算是饿汉式
class Bank {

    public static final Bank instance = new Bank();

    private Bank() {

    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Bank b1 = Bank.instance;
        Bank b2 = Bank.instance;

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(Bank.instance);
    }
}
