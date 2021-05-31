package basic.day12.java4;

/*
    面向对象特征之三：多态性

    1.理解多态性：可以理解为一个事物的多种形态

    2.何为多态性：
        父类的引用指向子类的对象，或子类的对象赋值给父类的引用
        子类的对象，指的是堆中的实例对象

    3.多态的使用：虚拟方法调用
        有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法
        总结：编译看左边，执行看右边（只适用于方法，不适用于属性）

    4.多态性的使用前提：
        1）类的继承关系
        2）方法的重写
        3）父类引用指向了子类实例

    5.对象的多态性，只适用于方法，不适用于属性（编译、运行，都看右边）
 */

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.age = 25;
        man.eat();
        man.earnMoney();

        //  对象的多态性：父类的引用指向子类的对象（堆中的实例对象）
        Person p2 = new Man();
        Person p3 = new Woman();

        //  多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 ---> 虚拟方法调用
        p2.eat();
        p2.walk();
        p3.eat();
        p3.walk();

//        p2.earnMoney();

        System.out.println(p2.id);  //  此处的id实际为Person中的id
    }
}
