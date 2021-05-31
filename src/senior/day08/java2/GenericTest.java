package senior.day08.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    1.泛型在继承方面的提现

    2.通配符的使用

    3.有限定条件的通配符的使用
 */
public class GenericTest {

    /*
        泛型在继承方面的提现
        虽然类A是类B的父类，但是G<A>和G<B>二者不具备继承关系（二者是并列关系）
        补充：类A是类B的父类，A<G>也是B<G>的父类
     */
    @Test
    public void test1() {
        Object object = null;
        String string = null;
        object = string;

        Object[] objects = null;
        String[] strings = null;
        objects = strings;

        //  list1与List2不具备继承关系
//        List<Object> list1 = null;
//        List<String> list2 = null;
//        list1 = list2;

        /*
            反证法：
            假设list1=list2;
                list1.add(123); 导致list2会混入非String的数据
         */
    }

    @Test
    public void test2() {
        List<String> list1 = null;
        AbstractList<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list2;
        list1 = list3;
        list2 = list3;
    }

    /*
        通配符的使用
        通配符：?
        类A是类B的父类，G<A>和G<B>不具备继承关系，二者共同的父类是：G<?>
     */
    @Test
    public void test3() {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<?> list = new ArrayList<>();
        list = list1;
        list = list2;

        show(list);
        show(list1);
        show(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        //  添加元素：对于List<?>就不能向其内部添加数据了，但是可以添加null
//        list.add("DD");
        list.add(null);

        //  获取元素：允许获取数据，获取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void show(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
        有限定条件的通配符的使用
            ? extends A：G<? extends A>可以作为G<A>和G<B>的父类，其中B是A的子类
            ? super A：G<? super A>可以作为G<A>和G<B>的父类，其中B是A的父类
     */
    @Test
    public void test4() {
        List<? extends Person> list1 = new ArrayList<>();
        List<? super Person> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //  读取数据
        Person person = list1.get(0);
        Object object = list2.get(0);

        //  写入数据
        list2.add(new Person());
        list2.add(new Student());
    }
}
