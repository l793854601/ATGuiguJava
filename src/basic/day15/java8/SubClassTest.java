package basic.day15.java8;

class SubClass extends SuperClass implements CompareA, CompareB {
    @Override
    public void method2() {
        System.out.println("SubClass：上海");
    }

    @Override
    public void method3() {
        System.out.println("subClass：深圳");
    }

    //  知识点5：如何在子类（或实现类）的方法中调用父类、接口宏被重写的方法
    public void myMethod() {
        //  调用自身重写的方法
        method3();
        //  调用父类中的方法
        super.method3();
        //  调用接口中的默认方法
        CompareA.super.method3();
        CompareB.super.method3();
    }
}

public class SubClassTest {
    public static void main(String[] args) {
//        subClass.method1();
//        SubClass.method1();

        //  知识点1：接口中定义的静态方法，只能接口调用
        CompareA.method1();

        //  知识点2：通过实现类的对象，可以调用接口中的默认方法
        //  如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写后的方法
        SubClass subClass = new SubClass();
        subClass.method2();
        //  知识点3：如果子类（或实现类）继承的父类和实现的接口中，声明了同名同参数的方法，
        //  那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法 ---> 类优先原则（仅针对于方法而言）
        //  知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
        //  那么在实现类没有重写此方法的情况下会报错（接口冲突）。
        //  这就需要我们必须在实现类中重写此方法
        subClass.method3();

    }
}
