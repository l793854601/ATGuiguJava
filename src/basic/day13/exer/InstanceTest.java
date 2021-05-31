package basic.day13.exer;

/*
    建立InstanceTest类，在类中定义方法method(Person e);
    在method中：
    （1）根据e的类型调用相应类的getInfo()方法
    （2）根据e的类型执行：
        如果e为Person类的对象，则输出：
        "a person"

        如果e为Student类的对象，则输出：
        "a student"
        "a person"

        如果e为Graduate类的西哎你个，则输出：
        "a graduated student"
        "a student"
        "a person"
 */

class Person {
    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name: " + name + "\n"
                + "age: " + age;
    }
}

class Student extends Person {
    protected String school = "pku";

    public String getInfo() {
        return "Name: " + name + "\n"
                + "age: " + age + "\n"
                + "school: " + school;
    }
}

class Graduate extends Student {
    protected String major = "IT";

    public String getInfo() {
        return "Name: " + name + "\n"
                + "age: " + age + "\n"
                + "school: " + school + "\n"
                + "major: " + major;
    }
}

public class InstanceTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Student();
        Person p3 = new Graduate();

        InstanceTest test = new InstanceTest();
        test.method(p1);
        test.method(p2);
        test.method(p3);
    }

    public void method(Person e) {
        System.out.println(e.getInfo());

        if (e instanceof Graduate) {
            System.out.println("a graduated student");
        }
        if (e instanceof Student) {
            System.out.println("a student");
        }
        if (e instanceof Person) {
            System.out.println("a person");
        }
    }
}
