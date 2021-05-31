package senior.day11.java2;

import org.junit.Test;
import senior.day11.java1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest {

    /*
        访问运行时类中指定的属性（方式1）
     */
    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //  创建运行时类对象
        Person p = clazz.newInstance();
        //  获取指定的属性
        Field id = clazz.getField("id");
        //  设置当前属性的值
        id.set(p, 123);
        //  获取当前属性的值
        int idValue = (int) id.get(p);
        System.out.println(idValue);
    }

    /*
        访问运行时类中指定的属性（方式2，更通用）
    */
    @Test
    public void testField1() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //  创建运行时类对象
        Person p = clazz.newInstance();
        //  获取指定的属性
        Field name = clazz.getDeclaredField("name");
        //  保证当前属性是可访问的
        name.setAccessible(true);
        //  设置当前属性的值
        name.set(p, "Tom");
        //  获取当前属性的值
        String nameValue = (String) name.get(p);
        System.out.println(nameValue);
    }


    /*
        访问运行时类中指定的方法
     */
    @Test
    public void testMethod() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        //  创建运行时类对象
        Person p = clazz.newInstance();
        //  获取指定的方法
        Method show = clazz.getDeclaredMethod("show", String.class);
        //  保证当前方法是可访问的
        show.setAccessible(true);
        //  调用当前方法，并获取方法返回值
        Object result = show.invoke(p, "China");
        System.out.println(result);

        //  调用运行时类的静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //  返回值为void的方法，调用invoke时，返回值为null
        //  具体执行invoke的三种形式
        System.out.println(showDesc.invoke(clazz));
        System.out.println(showDesc.invoke(p));
        System.out.println(showDesc.invoke(null));
    }

    /*
        访问运行时类中指定的构造器
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //  获取指定的构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        //  保证当前构造器是可访问的
        constructor.setAccessible(true);
        //  执行构造器，并获取返回的实例
        Person tom = constructor.newInstance("Tom");
        System.out.println(tom);
    }
}
