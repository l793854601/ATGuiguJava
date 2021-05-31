package basic.day15.java;

/*
    抽象类的应用：模板方法的设计模式
 */

abstract class BankTemplateMethod {
    //  1.取号
    public void takeNumber() {
        System.out.println("取号排队");
    }
    //  2.办理具体业务（交给子类实现）
    public abstract void transact();

    //  3.评价
    public void evaluate() {
        System.out.println("反馈评分");
    }

    //  模板方法：把基本操作组合到一起，子类一般不能重写
    public final void process() {
        takeNumber();
        transact(); //  像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码
        evaluate();
    }
}

class DrawMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要取钱！");
    }
}

class ManageMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要理财！");
    }
}

public class TemplateMethodTest {
    public static void main(String[] args) {
        BankTemplateMethod m1 = new DrawMoney();
        m1.process();

        BankTemplateMethod m2 = new ManageMoney();
        m2.process();
    }
}
