package senior.day07.exer2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


/*
    在List内去除重复数组，要求尽量简单
 */

public class CollectionTest {

    public static <T> List<T> duplicateList(List<T> list) {
        HashSet<T> set = new HashSet<>();
        set.addAll(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);
        List<Integer> list2 = duplicateList(list);

        Iterator<Integer> iterator = list2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
