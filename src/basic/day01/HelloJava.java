package basic.day01;

/*
    此注释为多行注释

    1.java规范的三种注释方式：
    单行注释
    多行注释
    文档注释

    2.单行注释、多行注释的作用：
    对所写的程序进行解释说明，增强可读性
    调试所写的代码（注释掉代码，使其不参与编译，即字节码文件中不会包含注释掉的代码）

    3.单行注释、多行注释的内容不参与编译

    4.文档注释的使用：
    文档注释可以被JDK提供的工具 javadoc所解析，生成一套以网页文件形式提现的该程序的说明文档

    5.多行注释不可嵌套使用
 */

/**
 * 文档注释示例
 * @author TAKUMI
 * @version v1.0
 */

public class HelloJava {
    /*
        多行注释：
        如下的main方法是程序的入口
     */
    public static void main(String[] args) {
        //  单行注释：如下的语句表示输出到控制台
        System.out.println("Hello, Java!");
    }
}
