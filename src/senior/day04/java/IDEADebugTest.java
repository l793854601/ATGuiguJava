package senior.day04.java;

import org.junit.Test;

public class IDEADebugTest {

    @Test
    public void test() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());    //  4
        System.out.println(sb); //  "null"

        //  内部会使用str.length()，但str为null，因此会抛出异常
        StringBuffer sb1 = new StringBuffer(str);   //  crash：NullPointerException
        System.out.println(sb1);
    }
}
