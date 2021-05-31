package senior.day06.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
    区分List中的remove(int index)方法和remove(Object obj)方法
 */

public class ListExer {

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        list.remove(2);
//        list.remove(Integer.valueOf(2));
    }
}
