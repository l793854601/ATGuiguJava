package senior.day10.java;

import org.junit.Test;

import java.io.*;

/*
    对象流的使用
    1.ObjectInputStream、ObjectOutputStream
    2.作用：用于存储和读取基本数据类型或对象的处理流。
            它的强大之处就是可以把Java中的对象写入到数据源中，肯能把对象从数据源中还原回来。
    3.要想一个Java对象是可序列化的，需要满足相应的要求（见Person类）
 */
public class ObjectInputOutputTest {

    /*
        序列化的过程：将内存中的Java对象保存到磁盘或者通过网络传输出去
        使用ObjectOutputStream
     */
    @Test
    public void testObjectOutputStream() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("object.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject("Hello World Need For Speed 21");
            objectOutputStream.writeObject(new Person("Jenny", 18));
            objectOutputStream.writeObject(new Person("TAKUMI", 23, new Account(2333)));
            objectOutputStream.flush(); //  显式刷新操作
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        反序列化的过程：将磁盘文件中的对象还原为内存中的Java对象
        使用ObjectInputStream
     */
    @Test
    public void testObjectInputStream() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("object.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            String string = (String) objectInputStream.readObject();
            System.out.println(string);

            Person person1 = (Person) objectInputStream.readObject();
            System.out.println(person1);

            Person person2 = (Person) objectInputStream.readObject();
            System.out.println(person2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
