package basic.day08;

/*
    类中方法的声明和使用

    方法：描述类应该具有的功能
    比如：Math类：sqrt()、random()等
          Scanner类：nextXxx()等
          Arrays类：sort()、toString()等

    1.举例：
    public void eat();
    public void sleep(int hour);
    public void sleep(int hour);
    public String getNation(String nation);

    2.方法的声明：权限修饰符 返回值类型 方法名(形参列表) { //  如果没有形参则不写
                        方法体
                 }
      注意：static final abstract 来修饰的方法，后面再讲

    3.说明：
        3.1 权限修饰符：
        java规定的4种权限修饰符：private、public、缺省（default、friendly）、protected -->封装性再细说

        3.2 返回值类型：有返回值、无返回值
            3.2.1 如果方法有返回值，则必须在方法名声明时，指定返回值的类型。
                  同时，方法中需要使用return来返回指定类型的数据

                  如果方法没有返回值，则方法声明时，使用void来表示。
                  通常，无返回值的方法中，就不需要return了。如果使用，只能使用"return;"来表示此方法结束，返回

            3.2.2 我们定义的方法该不该有返回值？
                  > 业务要求
                  > 凭借经验

        3.3 方法名：属于标识符，遵循标识符的规则和规范，"见名知意"

        3.4 形参列表：方法可以声明0个、1个、或者多个形参
            3.4.1 格式：数据类型 形参1. 数据类型 形参2, ...

            3.4.2 我们定义的方法该不该有形参？
                  > 业务要求
                  > 凭借经验

        3.5 方法体：方法功能的实现

    4.return关键字的使用：
        1.使用范围：使用在方法体中
        2.作用：
           > 结束方法（无返回的方法，如果想提前结束，则可以使用return）
           > 针对于有返回值类型的方法，使用"return 数据;"，将数据返回
        3.注意：return关键字后面不可以声明执行语句

    5.方法的使用：可以调用当前类的属性、方法
                  方法中不能定义方法
 */

class Customer {
    //  属性
    String name;
    int age;
    boolean isMale;

    //  方法
    public void eat() {
        System.out.println("客户吃饭");
    }

    public void sleep(int hour) {
        System.out.println("休息了" + hour + "个小时");
    }

    public String getName() {
        return name;
    }

    public String getNation(String nation) {
        String info = "我的国籍是：" + nation;
        return info;
    }
}

public class CustomerTest {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.eat();
    }
}
