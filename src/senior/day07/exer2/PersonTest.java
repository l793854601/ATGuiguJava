package senior.day07.exer2;

import org.junit.Test;

import java.util.HashSet;

public class PersonTest {

    @Test
    public void test1() {
        HashSet set = new HashSet();

        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);

        p1.name = "CC";
        //  删除失败，因为p1的hashCode()已经改变，删除p1时找不到对应的索引
        System.out.println(set.remove(p1));
        System.out.println(set);    //  1001 CC、1002 BB

        set.add(new Person(1001, "CC"));    //  1001 CC、1002 BB、1001 CC
        System.out.println(set);

        //  可添加成功，虽然1001 CC处已存在元素，但1001 CC与1001 AA的equals()不相同，因此会添加成功（已链表的形式存储）
        set.add(new Person(1001, "AA"));    //  1001 CC、1002 BB、1001 CC、1001 AA
        System.out.println(set);
    }
}
