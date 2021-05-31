package senior.day11.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    开发中，大部分还是使用new的方式，直接调用构造器创建对象。
    反射的特征：动态性（对比Objective-C的runtime）
    反射机制破坏了面向对象中的封装性（反射机制可以访问私有属性、方法）

    关于java.lang.Class类的理解：
    1.类的加载过程：
        1）程序经过javac.exe命令后，会生成一个或多个字节码文件（.class）。
        2）接着使用java.exe对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中（此过程就成为类的加载）。
        3）加载到内存中的类，就称之为运行时类，此运行时类，就作为Class类的一个实例（对比Objective-C中类、元类的关系）
    2.换句话说，Class的实例对应者一个运行时类
    3.加载到内存中的运行时类，会缓存一定的时间，在此时间之内，可以通过不同的方式来获取此运行时类
 */
public class ReflectionTest {

    /*
        反射之前，对于Person的操作
     */
    @Test
    public void test1() {
        //  1.创建Person类的实例
        Person p1 = new Person("Tom", 12);
        //  2.通过实例，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1);

        p1.show();

        //  在Person外部，不可以通过Person类的实例，调用其私有属性、方法
//        p1.name = "TKM";
//        p1.showNation("China");
    }

    /*
        反射之后，对于Person的操作
     */
    @Test
    public void test2() {
        try {
            Class<Person> clazz = Person.class;
            //  1.通过反射创建Person类的实例
            Constructor constructor = clazz.getConstructor(String.class, int.class);
            Object object = constructor.newInstance("Tom", 12);
            Person person = (Person) object;
            System.out.println(person);

            //  2.通过反射，调用实例指定的属性、方法
            //  调用属性
            Field age = clazz.getDeclaredField("age");
            age.set(person, 10);
            System.out.println(person);

            //  调用方法
            Method show = clazz.getMethod("show");
            show.invoke(person);

            //  3.通过反射，可以调用Person类的私有属性、方法
            //  获取私有构造器
            Constructor<Person> privateConstructor = clazz.getDeclaredConstructor(String.class);
            privateConstructor.setAccessible(true);

            //  通过私有构造器，实例化Person对象
            Person person1 = privateConstructor.newInstance("Jerry");
            System.out.println(person1);

            //  获取私有属性并赋值
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person1, "Jenny");
            System.out.println(person1);

            //  获取私有方法并调用
            Method showNation = clazz.getDeclaredMethod("showNation", String.class);
            showNation.setAccessible(true);
            Object china = showNation.invoke(person1, "China");
            String string = (String) china;
            System.out.println(string);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /*
        获取Class实例的四种方法
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //  方式1：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //  方式2：通过运行时类的对象，调用方法：getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //  方式3：调用Class的静态方法：forName(String className)
        //  此方式会抛出java.lang.ClassNotFoundException异常，需要处理
        Class clazz3 = Class.forName("senior.day11.java.Person");

        //  方式4：使用ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("senior.day11.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
    }

    /*
        Class实例可以是以下结构
     */
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //  只要是数组的元素类型与纬度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
