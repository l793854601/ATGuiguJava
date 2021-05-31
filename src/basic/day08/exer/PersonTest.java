package basic.day08.exer;

/*
    要求：
    （1）创建Person类的对象，设置该对象的name、age、sex属性
    调用study方法，输出字符串"studying"
    调用showAge方法，显示age值
    调用addAge方法给对象的age属性增加2岁
    （2）创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系

 */

class Person {
    String name;
    int age;
    int sex;    //  0:女 1:男

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println("age = " + age);
    }

    public int addAge(int i) {
        age += i;
        return age;
    }
}

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "Tom";
        p1.sex = 0;

        p1.study();
        p1.showAge();
        int newAge = p1.addAge(2);
        System.out.println("New age = " + newAge);

        Person p2 = new Person();
        p2.showAge();
    }
}
