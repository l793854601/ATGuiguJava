package basic.day13.java2;

/*
    java中的JUnit单元测试
    1.使用import导入org.junit.Test;
    2.创建java类，进行单元测试，此时的java类要求：
        1）此类的权限是public的
        2）此类提供无参的构造器
    3.此类中声明单元测试方法，此时的单元测试方法要求：
        1）方法的权限是public
        2）没有返回值，没有形参
    4.次单元测试方法上需要声明注解：@Test
    5.声明好单元测试方法以后，就可以在此方法体内测试相关的代码
    6.光标移至测试方法，右键，选择run'方法名'

    说明：
    1.如果执行结果没有异常，则会正确执行测试步骤
    2.如果执行结果出现异常，则会抛出相应的异常信息
 */

import org.junit.Test;

public class JUnitTest {

    int num = 10;

    public static void main(String[] args) {

    }

    @Test
    public void testEquals() {
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
        System.out.println(num);

        show();
    }

    @Test
    public void testToString() {
        String s2 = "MM";
        System.out.println(s2.toString());
    }

    private void show() {
        num = 20;
        System.out.println(num);
    }
}
