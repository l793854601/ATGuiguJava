package basic.day12.java4;

/*
    多态性的使用举例一：
 */

class Animal {

    public void eat() {
        System.out.println("动物进食");
    }

    public void shout() {
        System.out.println("动物叫");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}

//  举例二：
class Order {
    //  Object意味着：只要是Object类的对象或者是Object的子类的对象，都可以作为此方法的参数进行传递
    public void method(Object object) {

    }
}

public class AnimalTest {
    public void func(Animal animal) {
        animal.eat();
        animal.shout();
    }

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());
        test.func(new Cat());
    }
}
