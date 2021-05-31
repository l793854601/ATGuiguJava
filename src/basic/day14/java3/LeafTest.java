package basic.day14.java3;
//  总结：由父及子、静态先行
class Root {
    static {
        System.out.println("Root的静态初始化块");
    }

    {
        System.out.println("Root的普通初始化块");
    }

    public Root() {
        System.out.println("Root的无参的构造器");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid的静态初始化块");
    }

    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid() {
        System.out.println("Mid的无参的构造器");
    }

    public Mid(String msg) {
        this();
        System.out.println("Mid的带参构造器，其参数值：" + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf的静态初始化块");
    }

    {
        System.out.println("Leaf的普通初始化块");
    }

    public Leaf() {
        super("尚硅谷");
        System.out.println("Leaf的构造器");
    }
}

/*
    执行顺序：

    //  首先加载静态初始化块
    Root的静态初始化块
    Mid的静态初始化块
    Leaf的静态初始化块

    Root的普通初始化块
    Root的无参的构造器

    Mid的普通初始化块
    Mid的无参的构造器
    Mid的带参构造器，其参数值：尚硅谷

    Leaf的普通初始化块
    Leaf的构造器


 */

public class LeafTest {
    public static void main(String[] args) {
        new Leaf();
        System.out.println();
        new Leaf();
    }
}
