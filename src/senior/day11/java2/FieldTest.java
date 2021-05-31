package senior.day11.java2;

import org.junit.Test;
import senior.day11.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
    获取当前运行时类的属性结构
 */
public class FieldTest {

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //  获取属性结构
        //  getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();

        //  getDeclaredFields()：获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    /*
        属性的结构：权限修饰符、数据类型、变量名
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //  1.权限修饰符
            int modifiers = field.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(modifiers));

            //  2.数据类型
            Class<?> type = field.getType();
            System.out.println("数据类型：" + type.getName());

            //  3.变量名
            String name = field.getName();
            System.out.println("变量名：" + name);

            System.out.println();
        }
    }
}
