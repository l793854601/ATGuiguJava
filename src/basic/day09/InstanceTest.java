package basic.day09;

/*
    一、理解"万事万物皆对象"：
    1.在java语言范畴中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构
        > Scanner、String等
        > 文件：File
        > 网络资源：URL
    2.涉及到java语言与前端html、后端数据库交互时，前后端的结构在java层面交互时，都体现为类、对象。

    二、内存解析的说明：
    1.引用类型的变量，只可能存储两类值：null、或地址值（准确的说：这个"地址值"包含了对象类型、对象hash值）

    三、匿名对象的使用：
    1.理解：我们创建的对象，没有显式赋给一个变量名，即为匿名对象
    2.特征：只能使用一次（每次创建的对象都是新的）
    3.使用：如下
 */

class PhoneFactory {
    public void show(Phone phone) {
        phone.sendEmail();
        phone.playGame();
    }
}

class Phone {
    double price;

    public void sendEmail() {
        System.out.println("发送邮件");
    }

    public void playGame() {
        System.out.println("玩游戏");
    }

    public void showPrice() {
        System.out.println("手机价格为：" + price);
    }
}

public class InstanceTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        System.out.println(p.toString());

        p.sendEmail();
        p.playGame();

        //  匿名对象
//        new Phone().sendEmail();
//        new Phone().playGame();

//        new Phone().price = 1999;
//        new Phone().showPrice();

        new PhoneFactory().show(new Phone());
    }
}
