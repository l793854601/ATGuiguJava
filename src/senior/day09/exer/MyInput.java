package senior.day09.exer;

/*
    创建一个类：MyInput，利用流实现如下方法：
    public String next();
    public int nextInt();
    public double nextDouble();
    public boolean nextBoolean();
    public short nextShort();
    public byte nextByte();
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput {
    public String next() {
        String data = "";
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            data = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public boolean nextBoolean() {
        return Boolean.getBoolean(next());
    }

    public short nextShort() {
        return Short.parseShort(next());
    }

    public byte nextByte() {
        return Byte.parseByte(next());
    }
}
