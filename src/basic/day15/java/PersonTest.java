package basic.day15.java;

/*
    抽象类的匿名子类
 */

class Worker extends Person {

    @Override
    public void breath() {

    }

    @Override
    public void eat() {

    }
}

public class PersonTest {
    public static void main(String[] args) {
        method(new Student());

        Worker worker = new Worker();
        method1(worker);    //  非匿名类、非匿名对象
        method1(new Worker());  //  非匿名类、匿名对象

        //  创建了一个匿名子类的非匿名对象
        Person p = new Person() {   //  此处实际上是Person的子类

            @Override
            public void eat() {
                System.out.println("好好吃东西");
            }

            @Override
            public void breath() {
                System.out.println("好好呼吸");
            }

            @Override
            public void walk() {
                System.out.println("好好走路");
            }
        };

        method1(p); //  匿名类、非匿名对象

        System.out.println(p.getClass().getName());     //  basic.day15.java.PersonTest$1
        System.out.println(p.getClass().getSimpleName());   //  此处可体现出匿名类的特点：匿名

        //  创建了一个匿名子类的匿名对象
        method1(new Person() {
            @Override
            public void eat() {
                System.out.println("好好好好吃饭");
            }

            @Override
            public void breath() {
                System.out.println("好好好好呼吸");
            }
        }); //  匿名类、匿名对象
    }

    public static void method1(Person person) {
        person.eat();
        person.walk();
        person.breath();
    }

    public static void method(Student student) {

    }
}
