package basic.day13.java2;

/*
    包装类的使用：
    1.java提供了8中基本数据类型对应的包装类，使得基本数据类型的变量具有了类的特征

    2.基本数据类型、包装类、String三者之间的相互转换
 */

import org.junit.Test;

class Order {
    boolean isMale; //  基本数据类型，默认值为false
    Boolean isFemale;   //  引用数据类型，默认值为null
}

public class WrapperTest {

    //  基本数据类型 --> 包装类：调用包装类的构造器
    @Test
    public void test1() {
        int i1 = 10;
        Integer in1 = new Integer(i1);  //  暂时不考虑自动拆箱
        System.out.println(in1);

        Integer in2 = new Integer("123");
        System.out.println(in2);

        //  如果转换失败，则会抛出异常：java.lang.NumberFormatException
//        Integer in3 = new Integer("123abc");
//        System.out.println(in3);

        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");   //  内部判断string只要与"true"相等（忽略大小写），则为true
        Boolean b3 = new Boolean("123");

        Order order = new Order();
        System.out.println(order.isMale);
        System.out.println(order.isFemale);
    }

    //  包装类 --> 基本数据类型：调用包装类的xxxValue方法
    @Test
    public void test2() {
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }


    /*
        在jdk 5.0加入了新特性：自动装箱、自动拆箱
    */
    @Test
    public void test3() {

        int num1 = 10;
        method(num1);   //  此处做了自从装箱：将int型的num1自动转换为Integer类型的对象

        //  自动装箱：基本数据类型 --> 包装类
        int num2 = 10;
        Integer in1 = num2; //  自动装箱

        boolean b1 = true;
        Boolean b2 = b1;    //  自动装箱

        //  自动拆箱：包装类 --> 基本数据类型
        int num3 = in1;
    }

    //  基本数据类型、包装类 --> String类型
    @Test
    public void test4() {
        int num1 = 10;
        //  方式1：使用"+"做连接运算
        String str1 = num1 + "";

        float f1 = 12.3f;
        //  方式2：使用String重载的valueOf方法
        String str2 = String.valueOf(f1);

        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);   //  此时调用的是String valueOf(Object obj)

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    //  String类型 --> 基本数据类型、包装类：调用包装类的parseXxx方法
    @Test
    public void test5() {
        String str1 = "123";

        //  错误的情况：
//        int num1 = (int) str1;
//        Integer in1 = (Integer) str1;

        //  此处要小心转换失败的情况：java.lang.NumberFormatException
        int num2 = Integer.parseInt(str1);

        String str2 = "true";
        String str3 = "true1";
        boolean b1 = Boolean.parseBoolean(str1);    //  true
        boolean b2 = Boolean.parseBoolean(str3);    //  false
    }

    public void method(Object object) {
        System.out.println(object.getClass().getSimpleName());
    }
}
