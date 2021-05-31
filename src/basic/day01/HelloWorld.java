//  此java文件所处的包
package basic.day01;

/**
 * JDK（Java Development Kit）java开发工具包
 * JRE（Java Runtime Environment）java运行环境
 * JDK = JRE + 开发工具集（例如javac（编译）、java（执行）等编译工具）
 * JRE = JVM + Java SE标准类库
 *
 * 使用public定一个类的访问控制域
 * 使用class关键字定义类
 * HelloWorld为类名，注意：类名的命名使用驼峰命名法，且首字母要大写
 *
 * java程序执行步骤：
 * 1.将java代码编写到扩展名为.java的文件（源文件）中
 * 2.通过javac命令对该文件进行编译，生成扩展名为.class的文件（字节码文件）
 * 3.通过java命令对.class的文件进行解释、运行
 *
 * 注意：
 * 一个java源文件中可以包含多个class，但只能有一个public class
 * 一个java源文件中的public class，类名必须与源文件名一致（比如public class Dog必须放在Dog.java中）
 *
 * 程序的入口是main()方法，格式是固定的。
 *
 * 输出语句：
 * System.out.println();    先输出数据，后换行
 * System.out.print();      输出数据后不换行
 *
 * java中每一条语句都要以";"结束。多条语句可以写到一行（但每一条也要以";"结束），但可读性较差。
 */

class AnotherHelloWorld {
    public static void main(String[] args) {    //  arguments：参数
        System.out.println("Hello, world!");
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
