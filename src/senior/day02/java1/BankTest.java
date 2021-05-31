package senior.day02.java1;

/*
    使用同步机制，将单例模式中的懒汉式改写为线程安全的
 */

class Bank {

    private static Bank instance;

    private Bank() {

    }

    public static Bank getInstance() {
        //  方式1：效率较差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//        }
//        return instance;

        //  方式2：双重检查，效率较方式1高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class BankTest {
}
