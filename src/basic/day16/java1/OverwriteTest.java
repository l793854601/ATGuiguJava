package basic.day16.java1;

/*
    方法重写的规则之一：
    子类重写的方法，抛出的异常类型，不大于父类被重写的方法抛出的异常类型
 */

import java.io.FileNotFoundException;
import java.io.IOException;

class SuperClass {
    public void method() throws IOException {

    }
}

class SubClass extends SuperClass {
    @Override
    public void method() throws FileNotFoundException {

    }
}

public class OverwriteTest {

    public void display() {
        SuperClass sc = new SubClass();
        try {
            sc.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
