package basic.day10.exer;

/*
    1.创建程序，在其中定义两个类，Person、PersonTest
    Person类定义如下：
    用setAge方法设置人的合法年龄（0~130），用getAge方法返回人的年龄

    在PersonTest类中实例化Person类的对象b，调用setAge、getAge方法

    2.在前面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18
 */

public class PersonTest {
    public static void main(String[] args) {
        Person b = new Person();
        System.out.println(b.getAge());

        b.setAge(-1);
        System.out.println(b.getAge());

        b.setAge(10);
        System.out.println(b.getAge());

        Person b2 = new Person(21, "Tom");
        System.out.println(b2.getAge());
        System.out.println(b2.getName());
    }
}
