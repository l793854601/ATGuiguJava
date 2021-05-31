package senior.day03.exer;

/*
    面试题
 */

public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";    //  此处改变的实际上是形参，并非StringTest中的str属性
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);   //  good
        System.out.println(ex.ch);  //  best
    }
}
