package senior.day04.exer;

/*
    获取两个字符串中最大相同子串
    比如：str1 = "abcwerthelloyulodef"，str2 = "cvhellobnm"
 */

import org.junit.Test;

public class StringMaxSameTest {

    @Test
    public void test1() {
        String string1 = "abcwerthelloyulodef";
        String string2 = "cvhellobnm";
        System.out.println(getMaxSame(string1, string2));
    }

    public String getMaxSame(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return null;
        }

        String longString = null;
        String shortString = null;
        if (string1.length() > string2.length()) {
            longString = string1;
            shortString = string2;
        } else {
            longString = string2;
            shortString = string1;
        }

        //  cvhellobnm
        String result = null;
        for (int i = 0; i < shortString.length(); i++) {
            for (int j = shortString.length(); j > i; j--) {
                String subString = shortString.substring(i, j);
                if (longString.contains(subString)) {
                    if (result == null || subString.length() > result.length()) {
                        result = subString;
                    }
                }
            }
        }

        return result;
    }
}
