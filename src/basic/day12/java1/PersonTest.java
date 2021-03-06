package basic.day12.java1;

/*
    方法的重写（override/overwrite）

    1.重写：子类继承父类以后，可以对父类同名同参数的方法进行覆盖操作

    2.应用：重写以后，当创建子类对象以后，通过子类对象调用父类中的同名同参的方法时，实际执行的是子类重写父类的方法

    3.重写的规定：
        方法的声明：权限修饰符 返回值类型 方法名(形参列表) throws 异常类型 {
                        方法体
                   }
        约定俗称：子类中的叫重写的方法，父类中的叫被重写的方法

        1）子类重写的方法的方法名和形参列表与父类中被重写的方法的方法名和形参列表相同
        2）子类重写方法的权限修饰符，不能不小于父类中被重写的方法的权限修饰符（如果小于，则无法构成多态）
            > 特殊情况：子类不能重写父类中声明为private权限的方法
                       这种情况下，子类中的方法相对于父类中的方法来说，是一个全新的方法，不构成重写
        3）返回值类型：
            > 如果父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
            > 如果父类被重写的方法的返回值类型是A类型，则子类重写的方法的返回值类型可以是A类或A类的子类（引用类型）
            > 如果父类被重写的方法的返回值类型是基本数据类型（比如：double），则子类重写的方法的返回值类型必须是相同的基本数据类型（必须也是double）

        4）子类重写的方法，抛出的异常类型，不大于父类被重写的方法抛出的异常类型

        子类和父类中的同名同参数的方法，要么同时声明为非static的，要么同时声明为static的（不是重写）
        重写仅涉及非static方法。
    区分方法的重载与重写：

 */

public class PersonTest {
    public static void main(String[] args) {
        Student s = new Student("软件工程");
        s.walk(10);
        s.study();
    }
}
