package basic.day16.java1;

/*
    一、异常的处理：抓抛模型

        过程1："抛"：程序在正常执行的过程当中，一旦出现异常，就会在异常代码出生成一个对应的异常类对象，
                     并将此对象抛出。
                    一旦抛出对象以后，其后的代码就不再执行。

               关于异常对象的产生：1）系统自动生成的异常对象
                                  2）手动生成一个异常对象，并抛出（throw）

        过程2："抓"：可以理解为异常的处理方式：1.try-catch-finally 2.throws


    二、try-catch-finally的使用：

        try {
            //  可能出现异常的代码
        } catch (异常类型1 变量名1) {
            //  处理异常1
        } catch (异常类型2 变量名2) {
            //  处理异常2
        } catch (异常类型3 变量名3) {
            //  处理异常3
        }
        ...
        finally {
            //  一定会执行的代码
        }

    说明：
    1.finally是可选的
    2.使用try将可能出现异常的代码包装起来，在执行过程中，一旦出现异常，就会出现一个对应异常类的对象，
      根据此对象的类型，去catch中进行匹配（类似于switch-case）
    3.一旦try中的异常对象匹配到某一个catch时，就进入到catch中进行处理。
      处理完毕之后，则跳出当前的try-catch结构（在没有写finally的情况下）。继续执行try-catch其后的代码
    4.catch中的异常类型如果没有子父类关系，则谁声明在上、下无所谓。
      catch中的异常类型如果存在子父类关系，则要求子类一定声明在父类的上面，否则会报错
    5.常用的异常对象处理的方式：1.getMessage() 2.printStackTract()
    6.在try-catch-finally结构中声明的变量，出了try结构（作用域）以后，就不能再被访问了
    7.使用try-catch-finally处理编译时异常，使得程序在编译期就不再报错，但是运行时仍然可能报错。
      相当于我们使用try-catch-finally结构将一个编译时可能出现的异常，延迟到运行时出现。

    体会1：使用try-catch-finally处理编译时异常，使得程序在编译时就不在报错，但是运行时仍然可能报错。
           相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现
    体会2：开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了。
           针对于编译时异常，一定套考虑异常的处理。
 */

import org.junit.Test;

public class ExceptionTest1 {

    @Test
    public void test1() {
        String str = "123";
        str = "abc";
        Integer i = 0;
        try {
            i = Integer.parseInt(str);
            System.out.println("hello-----1");
        } catch (NullPointerException e) {
            System.out.println("出现空指针异常了！");
        } catch (NumberFormatException e) {
            System.out.println("出现数值转换异常了！");
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }  catch (Exception e) {
            System.out.println("出现异常了！");
        } finally {

        }
        System.out.println(i);
        System.out.println("hello-----2");
    }
}
