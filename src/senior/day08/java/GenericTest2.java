package senior.day08.java;

class Father<T1, T2> {
    public void show(T1 t1, T2 t2) {

    }
}

//  子类不保留父类的泛型
class Son1 extends Father { //  等价于 class Son1 extends Father<Object, Object>

}

//  具体类型
class Son2 extends Father<Integer, String> {

}

//  子类保留父类的泛型
class Son3<T1, T2> extends Father<T1, T2> {

}

//  部分保留
class Son4<T2> extends Father<Integer, T2> {

}

public class GenericTest2 {
    public static void main(String[] args) {

    }
}
