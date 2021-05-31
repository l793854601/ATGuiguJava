package senior.day04.exer;

import org.junit.Test;

/*
    将一个字符串的指定部分进行反转
    比如"abcdefg"反转为"abfedcg"
*/

public class StringReverseTest {

    @Test
    public void test() {
        String str = "abcdefg";
        System.out.println(reverse(str, 2, 5));
        System.out.println(reverse1(str, 2, 5));
        System.out.println(reverse2(str, 2, 5));
    }

    public String reverse(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        char[] arr = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);
    }

    public String reverse1(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        String reverseStr = str.substring(0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            reverseStr += str.charAt(i);
        }
        reverseStr += str.substring(endIndex + 1);
        return reverseStr;
    }

    public String reverse2(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex ; i--) {
            sb.append(str.charAt(i));
        }
        sb.append(str.substring(endIndex + 1));
        return sb.toString();
    }
}
