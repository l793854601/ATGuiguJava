package senior.day11.java;

import org.junit.Test;

import java.util.Random;

/*
    通过反射，创建对应的运行时类的对象
 */
public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        /*
            调用此方法，创建对应的运行时类的对象，内部是调用了运行时类的空参构造器
            此方式下，需要满足以下条件才能创建对象：
            1.运行时类存在空参构造器
            2.该构造器的访问权限足够（通常为public，不能是private）

            在javabean中，要求提供一个public的空参构造器：
            1.便于通过反射，创建运行时类的对象
            2.便于子类继承此运行时类是，默认调用super()时，保证父类有次构造器
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    /*
        体会反射的动态性
     */
    @Test
    public void test2() {
        Random rand = new Random();
        int number = rand.nextInt(3);
        String classPath = null;
        switch (number) {
            case 0:
                classPath = "java.lang.Object";
                break;
            case 1:
                classPath = "senior.day11.java.Person";
                break;
            case 2:
                classPath = "java.lang.String";
                break;
        }
        if (classPath != null) {
            Object object = null;
            try {
                object = getInstance(classPath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(object);
        }
    }

    /*
        创建一个指定类的对象
        classPath：指定类的全类名
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        Object object = clazz.newInstance();
        return object;
    }
}
