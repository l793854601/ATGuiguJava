package senior.day11.java2;

import org.junit.Test;
import senior.day11.java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/*
    获取当前运行时类的方法结构
 */
public class MethodTest {

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //  获取方法结构
        //  getMethods()：获取当前运行时类及其父类中声明为public访问权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        //  getDeclaredMethods()：获取当前运行时类中声明的所有方法（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    /*
        方法的结构：注解、权限修饰符、返回值类型、方法名、参数类型1 形参名1, ...、异常
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //  1.注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //  2.权限修饰符
            int modifiers = method.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(modifiers));

            //  3.返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.println("返回值类型：" + returnType.getName());

            //  4.方法名
            String name = method.getName();
            System.out.println("方法名：" + name);

            //  5.形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            Parameter[] parameters = method.getParameters();
            int parameterCount = method.getParameterCount();
            System.out.println("形参列表：");
            for (int i = 0; i < parameterCount; i++) {
                System.out.println("形参" + i + "类型：" + parameterTypes[i].getName());
                System.out.println("形参" + i + "名：" + parameters[i].getName());
            }

            //  6.异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            System.out.println("异常：");
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType.getName());
            }

            System.out.println();
        }
    }
}
