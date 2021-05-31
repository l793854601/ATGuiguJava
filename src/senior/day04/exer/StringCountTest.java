package senior.day04.exer;

/*
    获取一个字符串在另一个字符串中出现的次数。
    比如：获取"ab"在"abkkcadkabkebfkabkskab"中的次数
 */

import org.junit.Test;

public class StringCountTest {

    @Test
    public void test() {
        String string = "abkkcadkabkebfkabkskab";
        String subString = "ab";
        System.out.println(getCount(string, subString));
    }

    public int getCount(String string, String subString) {
        if (string == null || subString == null || string.length() < subString.length()) {
            return 0;
        }

        int count = 0;
        while (true) {
            int index = string.indexOf(subString);
            if (index == -1) {
                break;
            }
            count++;
            string = string.substring(index + subString.length());
        }
        return count;
    }
}
