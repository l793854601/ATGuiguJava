package basic.day10.java1;

/*
    JavaBean是一种java语言写成的可重用组件
    所谓JavaBean，是指符合如下标准的java类：
    1.类是公有（public）的
    2.有一个无参的公共的构造器
    3.有属性，且有对应的get、set方法
 */

public class Customer {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
