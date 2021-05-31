package basic.day10.java;

/*
    面向对象的特征一：封装与隐藏
    1.问题的引入：
    当我们创建一个类的对象以后，我们可以通过"对象.属性"的方式，对对象的属性进行赋值。
    这里，赋值操作要收到属性的数据类型和存储范围的制约。除此之外，没有其他制约条件。
    但是，在实际问题中，我们往往需要给属性赋值加入额外的限制条件。这个条件就不能再属性声明时提现。
    我们只能通过方法（set方法）进行限制条件的添加。
    同时，我们需要避免用户再使用"对象.属性"的方式对属性赋值，则需要将属性声明为私有的（private）
    此时，针对于属性，就体现了封装性。

    2.封装性的体现：
    我们将类的属性私有化（private），同事，提供公共（public）的方法来设置（set）和获取（get）此属性的值

    拓展：封装性的提现：
        1）属性的隐藏
        2）不对外暴露的私有方法
        3）单例模式（构造器私有化）

    3.封装性的体现：需要权限修饰符来配合。
    1）java规定的4中权限，从小到大排列：private、缺省（default、friendly）、protected、public
    2）4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
    3）具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
            修饰类（目前仅涉及外部类），只能使用：缺省、public

    总结封装性：java提供了4中权限修饰符来修饰类及类的内部结构，来提现类及类的内部结构在被调用时的可见性的大小
 */

class Animal {

    String name;
    private int age;
    private int legs;

    public void eat() {
        System.out.println("动物进食");
    }

    public void show() {
        System.out.println("name = " + name + ", age = " + age + ", legs = " + legs);
    }

    //  对于属性的设置（set）
    public void setLegs(int l) {
        if (l > 0 && l % 2 == 0) {
            legs = l;
        } else {
            legs = 0;
            //  抛出异常
        }
    }

    //  对于属性的获取（get）
    public int getLegs() {
        return legs;
    }

    public void setAge(int a) {
        if (a > 0) {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "大黄";
//        a.age = 1;
        a.setAge(1);
//        a.legs = 4;   //  legs 在 basic.day10.java.Animal 中是 private 访问控制
        a.setLegs(6);

        a.show();
//        System.out.println(a.legs);
        System.out.println(a.getLegs());
    }
}
