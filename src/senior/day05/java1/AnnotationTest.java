package senior.day05.java1;

/*
    注解的使用：
    1.理解Annotation：
        1）jdk5.0新增的功能
        2）Annotation其实就是代码里的特殊标记。这些标记可以在编译、类加载、运行时被读取，并执行相应的处理。
           通过使用Annotation，程序员可以在不改变原有的逻辑的情况下，在源文件中嵌入一些补充信息。
        3）在JavaSE中，注解的使用目的比较简单，例如标记伙食的功能，忽略警告等。
           在JavaEE/Android中，注解占据了更重要的角色，例如用来配置应用程序的任何切面、代替JavaEE旧版中所遗留的繁冗代码和XML配置等。

    2.Annotation的使用示例：
    示例一：生成文档相关的注解
    示例二：在编译时进行格式检查（JDK内置的三个基本注解）
        @Override：限定重写父类的方法，该注解只能用于方法
        @Deprecated：用于表示所修饰的元素（类、方法等）已过时，通常是因为所修饰的结构危险或存在更好的选择
        @SuppressWarning：抑制编译器警告
    示例三：跟踪代码依赖性，实现替代配置文件功能

    3.如何自定义注解：参照@SuppressWarning定义
        1）注解声明为@interface
        2）内部定义成员，通常使用value()表示
        3）可以使用成员的默认值，使用default定义
        4）如果自定义的注解没有成员，表明是一个标识作用
    如果注解有成员，在使用注解时，需要指明成员的值
    自定义注解必须配上注解的信息处理流程（使用反射）才有意义
    自定义注解通常都会指明两个元注解：@Retention、@Target

    4.jdk提供的4种元注解：
    元注解：对现有的注解进行解释说明的注解
        @Retention：指定所修饰Annotation的生命周期：SOURCE/CLASS（默认行为）/RUNTIME
            SOURCE：在源文件中有效（即源文件保留），编译器会直接丢弃这种策略注释（java文件编译为class文件后，注解不可见）
            CLASS：在class文件中有效（即class保留），当运行java程序时，JVM不会保留注解
            RUNTIME：在运行时有效（即运行时保留），当运行java程序时，JVM会保留注解，程序可以通过反射获取该注解
        @Target：指定所修饰的Annotation能用于修饰哪些程序元素
            CONSTRUCTOR：构造器
            FIELD：域（成员变量）
            LOCAL_VARIABLE：局部变量
            METHOD：方法
            PACKAGE：包
            PARAMETER：参数
            TYPE：类、结构、注解、enum
            ANNOTATION_TYPE：注解
        @Documented：表示所修饰的注解在被javadoc解析时，保留下来
        @Inherited：被它修饰的Annotation将具有继承性

    5.通过反射获取注解信息

    5.jdk8中注解的新特性：可重复注解、类型注解
        可重复注解：
            1.在@MyAnnotation中声明@Repeatable，成员值为@MyAnnotations.class
            2.@MyAnnotations的@Target、@Retention、@Inherited等元注解，必须跟@MyAnnotation相同

        类型注解：
            ElementType.TYPE_PARAMETER：表示该注解能写在类型变量的声明语句中（如：泛型类型）
            ElementType.TYPE_USE：表示该注解能写在使用类型的任何语句中
 */

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


//  jdk8之前的写法
//@MyAnnotations({@MyAnnotation("hi"), @MyAnnotation("hei")})
//  jdk8之后的写法
@MyAnnotation("hi")
@MyAnnotation("hei")
class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation("hi")
    public void walk() {
        System.out.println("人走路");
    }

    @MyAnnotation()
    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }

    //  编译时会校验
    //    @Override
//    public void eat1() {
//        super.eat();
//    }
}

class Generic<@MyAnnotation T> {
    public void show() throws @MyAnnotation RuntimeException {
        List<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }
}

public class AnnotationTest {
    public static void main(String[] args) {

    }

    /*
        证明：
        通过@Inherited，使得继承自Person类的Student类也具有@MyAnnotation
     */
    @Test
    public void test1() {
        Class<Student> clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
