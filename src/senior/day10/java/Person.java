package senior.day10.java;

import java.io.Serializable;

/*
    Person类需要满足如下的要求，方可序列化
    1.需要实现java.io.Serializable接口（此接口无任何方法需要实现，为标识接口）
    2.需要当前类提供一个全局常量static final long serialVersionUID作为唯一标识
    3.除了当前类（Person）需要实现java.io.Serializable接口，还需要保证其内部所有成员变量也必须是可序列化的
      默认情况下，基本数据类型是可序列化的
    4.序列化机制：
        对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
        或通过网络将这种二进制流传输到另一个网络节点。
        当其他程序获取了这种二进制流，就可以恢复成原来的Java对象。

    解释：为什么需要serialVersionUID
    1.当类没有显示定义serialVersionUID时，系统会默认分配一个serialVersionUID给当前类
    2.如果序列化当前类的对象之后，对当前类做了修改（增加了属性、方法等），在反序列化时，会抛出异常java.io.InvalidClassException

    补充：ObjectOutputStream、ObjectInputStream不能序列化static和transient修饰的成员变量（static不是对象所有的属性）
 */
public class Person implements Serializable {

//    ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
    public static final long serialVersionUID = 4000090908792L;

    private static String GENDER;

    private transient int money = 100;

    private String name;

    private int age;

    private Account account;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        GENDER = "MALE";
    }

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
        GENDER = "FEMALE";
    }

    public static String getGENDER() {
        return GENDER;
    }

    public static void setGENDER(String GENDER) {
        Person.GENDER = GENDER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("gender=").append(GENDER);
        sb.append(", money=").append(money);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }
}

class Account implements Serializable {

    public static final long serialVersionUID = 4000090908793L;

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}