package senior.day11.java2;

import org.junit.Test;
import senior.day11.java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class OtherTest {

    /*
        获取运行时类的构造器
     */
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        //  getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //  getDeclaredConstructors()：获取当前运行时类中声明的所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }
    }

    /*
        获取运行时类的父类
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;

        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
        获取运行时类的带泛型的父类
    */
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
        获取运行时类的带泛型的父类的泛型
    */
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //  获取泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }

    /*
        获取运行时类实现的接口
     */
    @Test
    public void test5() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        System.out.println();

        //  获取运行时父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class<?> anInterface : interfaces1) {
            System.out.println(anInterface);
        }
    }

    /*
        获取运行时类所在的包
     */
    @Test
    public void test6() {
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /*
        获取运行时类声明的注解
     */
    @Test
    public void test7() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
