package basic.day10.java;

import java.util.Arrays;

public class ValueTransferTest {
    public static void main(String[] args) {
        String s1 = "hello";

        ValueTransferTest test = new ValueTransferTest();
        test.change(s1);
        System.out.println(s1);

        int[] a = new int[10];
        test.change(a);
        System.out.println(Arrays.toString(a));
    }

    public void change(String s) {
        s = "hi~";
    }

    public void change(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }
}
