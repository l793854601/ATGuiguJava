package basic.day15.java2;

public class InterClassTest1 {

    //  开发中很少见
    public void method() {
        //  局部内部类
        class AA {

        }
    }

    //  返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {
        //  方式1
//        //  创建一个Comparable接口的类
//        class MyComparable implements Comparable {
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        //  返回此类的对象
//        return new MyComparable();

        //  方式2
        return new Comparable() {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
