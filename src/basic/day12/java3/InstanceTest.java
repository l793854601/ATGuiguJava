package basic.day12.java3;

/*
    子类对象实例化的全过程：

    1.从结果上来看：（继承性）
        子类继承父类以后，就获取了父类中声明的属性或方法。
        创建子类的对象，在堆空间中，就会加载所有父类（直接父类、间接父类）的属性。

    2.从过程上来看：
        当我们通过子类的构造器创建子类对象时，我们一定会直接或间接的调用其父类的构造器，直到调用了java.lang.Object类中空参的构造器为止。
        正因为加载过所有的父类的结构，才可以看到内存中有父类的结构，子类对象才可以考虑调用。
        参考：swift中的指定构造器与便利构造器，最终都是会调用到根类的构造器。这样保证了类中的属性都会被初始化（swift号称是一门安全的语言）

    明确：虽然调用子类对象时，调用了父类的构造器，但是自始至终就创建了一个对象，即为new的子类对象。
 */

class Creator {
    int age;

    public Creator() {
        System.out.println("Creator()");
    }
}

class Animal extends Creator {
    String name;
    String food;

    public Animal() {
        System.out.println("Animal()");
    }
}

class Dog extends Animal {
    String hostName;

    public Dog() {
        System.out.println("Dog()");
    }
}

public class InstanceTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.age = 10;
        dog.name = "Papi";
        dog.food = "Meat";
        dog.hostName = "TKM";
    }
}
