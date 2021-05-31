package senior.day06.java;

/*
    jdk5.0新增了foreach循环，用于遍历集合和数组
 */

import org.junit.Test;
import senior.day06.java.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //  for (集合元素的类型 局部对象 : 集合对象)
        //  内部仍然使用迭代器Iterator
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /*
        练习题
     */
    @Test
    public void test3() {
        String[] arr = new String[] {"MM", "MM", "MM"};

        //  方式1：
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";    //  修改了数组中的元素
//        }

        System.out.println(Arrays.toString(arr));   //  [GG, GG, GG]

        //  方式2：
        for (String s : arr) {
            s = "GG";   //  局部变量赋值
        }

        System.out.println(Arrays.toString(arr));   //  [MM, MM, MM]
    }
}
