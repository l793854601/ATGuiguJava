package senior.day09.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    统计文本文件中每个字符出现的次数，并记录在Map中，输出
 */
public class CharCountTest {

    @Test
    public void test() {
        Reader reader = null;
        Map<Character, Integer> map = new LinkedHashMap<>();
        try {
            reader = new FileReader("Hello.txt");
            int data = -1;
            while ((data = reader.read()) != -1) {
                char ch = (char) data;
                if (map.containsKey(ch)) {
                   int count = map.get(ch);
                   count++;
                   map.put(ch, map.get(ch));
                } else {
                    map.put(ch, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(map);

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
