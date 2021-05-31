package senior.day08.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
    File练习
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("/Users/liudelong/Desktop/note/ATGuiguJava/Hello.txt");
        //  创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(), "haha.txt");
        if (!destFile.exists()) {
            boolean createNewFile = destFile.createNewFile();
            if (createNewFile) {
                System.out.println("创建成功");
            }
        }
    }

    /*
        判断指定目录下是否有后缀名为.jog的文件，如果有，就输出该文件名称
     */
    @Test
    public void test2() {
        File dir = new File("/Users/liudelong/Desktop/note/ATGuiguJava/");
        File[] files = dir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.endsWith(".jpg"));
            System.out.println(fileName);
        }
    }
}
