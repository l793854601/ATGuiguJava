package basic.day14.java2;

/*
    main()方法的使用说明
    1.main()方法作为程序的入口出现
    2.main()方法也是一个普通的静态方法
    3.main()方法也可以作为我们与控制台交互的方式（通过形参：String[] args）
 */

public class MainTest {
    public static void main(String[] args) {
        args = new String[100];
        Main.main(args);
    }
}

class Main {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            args[i] = "args_ " + i;
            System.out.println(args[i]);
        }
    }
}