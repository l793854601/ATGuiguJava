package basic.day14.java;

import org.junit.Test;

public class ReviewTest {

    @Test
    public void test1() {
        //  数组是引用类型，可认为数组是继承于Object类的
        int[] arr = new int[] {1, 2, 3};
        print(arr); //  利用多态性来证明数组是继承于Object类的
        System.out.println(arr.getClass());
        System.out.println(arr.getClass().getSuperclass());
    }

    //  区别手写的和自动生成的equals()方法
    @Test
    public void test2() {
        Person p = new Person("Tom", 12);
        Man m = new Man("Tom", 12);
        Person p1 = new Person("Tom", 12);
        System.out.println(p.equals(m));
        System.out.println(p.equals(p1));
    }

    //  关于toString()
    @Test
    public void test3() {
        String s = "abc";
        System.out.println(s);
        System.out.println(s.toString());

        s = null;
        System.out.println(s);  //  null
//        System.out.println(s.toString()); //  空指针异常
    }

    public void print(Object obj) {
        System.out.println(obj);
    }
}
