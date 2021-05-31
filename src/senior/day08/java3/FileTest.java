package senior.day08.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

/*
    File类的使用
    1.File类的一个对象，代表一个文件或一个文件目录
    2.File类声明在java.io下
    3.File类设计到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
      并未涉及到写入或读取文件内容给的操作。如果需要读取或写入文件内容，则需要使用IO流来完成
    4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点"
 */
public class FileTest {

    /*
        1.如何创建File类的实例
            //  PathName可以为相对路径，也可以为绝对路径
            File(String pathName);

            //  parent：文件所在目录
            //  child：文件/文件目录
            File(String parent, String child);

            //  parent：文件所在目录的File对象
            //  child：文件/文件目录
            File(File parent, String child);

        2.路径：
            相对路径：相较于某个路径下指明的路径
            绝对路径：包含盘符在内的文件或文件目录的路径

            注意：
            在IDEA中：
            如果开发使用JUnit中的单元测试方法测试，则相对路径为当前Module下
            如果开发使用main()方法测试，则相对路径为当前Project下

            在Eclipse中：
            无论是单元测试，还是在main()方法中，相对路径都是当前的Project下

        3.路径分隔符：
            windows：\\
            unix：/
            为了适配不同系统，应该使用File.separator表示路径分隔符
     */
    @Test
    public void test1() {
        //  构造器1
        File file1 = new File("hello.txt");  //  hello.txt是相对于当前module（ATGuiguJava）的路径
        File file2 = new File("/Users/liudelong/Desktop/note/ATGuiguJava/hi.txt");  //  hello.txt相对于当前module
        System.out.println(file1);
        System.out.println(file2);

        //  构造器2
        //  在parent目录下（/Users/liudelong/Desktop/note/ATGuiguJava/）的child文件/文件夹（hi.txt）
        File file3 = new File("/Users/liudelong/Desktop/note/ATGuiguJava/", "hi.txt");
        System.out.println(file3);

        //  构造器3
        File parent = new File("/Users/liudelong/Desktop/note/ATGuiguJava/");
        File file4 = new File(parent, "hi.txt");
        System.out.println(file4);
    }

    /*
        File类的常用方法：
        public String getAbsolutePath()：获取绝对路径
        public String getPath()：获取路径
        public String getName()：获取文件名
        public String getParent()：获取上层目录路径，若无，则返回null
        public long length()：获取文件长度（字节数），不能获取目录的长度，若文件不存在则返回0
        public long lastModified()：获取最后一次的修改时间（毫秒值），若文件不存在则返回0
     */
    @Test
    public void test3() {
        File file1 = new File("9Hello.txt");
        File file2 = new File("/Users/liudelong/Desktop/note/ATGuiguJava/hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(Instant.ofEpochMilli(file1.lastModified()).atZone(ZoneId.systemDefault()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(Instant.ofEpochMilli(file2.lastModified()).atZone(ZoneId.systemDefault()));
    }

    /*
        如下的两个方法，适用于文件目录
        public String[] list()：获取指定目录下的所有文件或者文件目录的名称数组
        public File[] listFiles()：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test4() {
        File file = new File("/Users/liudelong/Desktop/note/ATGuiguJava");
        System.out.println(Arrays.toString(file.list()));
        System.out.println();
        System.out.println(Arrays.toString(file.listFiles()));
    }

    /*
        public boolean renameTo(File dest)：把文件重命名为指定的文件路径
        比如：file1.rename(file2)
            要想保证返回true，需要file1在硬盘中真实存在，且file2不存在
     */
    @Test
    public void test5() {
        File file1 = new File("Hello.txt");
        File file2 = new File("/Users/liudelong/Desktop/note/ATGuiguJava/hi.txt");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);   //  false
    }

    /*
        以下方法，需要当前File对象真实存在于硬盘中，才会返回有效值
        public boolean isDirectory()：是否是文件目录
        public boolean isFile()：是否是文件
        public boolean exists()：是否真实存在于硬盘中
        public boolean canRead()：是否可读
        public boolean canWrite()：是否可写
        public boolean isHidden()：是否隐藏
     */
    @Test
    public void test6() {
        File file1 = new File("Hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        //  file1不存在，以下值都返回false
        file1 = new File("Hello1.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("/Users/liudelong/Desktop/note/ATGuiguJava");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    /*
        创建硬盘中对应的文件或文件目录
        public boolean createNewFile()：创建文件，如果文件存在，则不创建，并返回false
        public boolean mkdir()：创建文件目录，如果此文件目录存在，则不创建。如果此文件目录的上层目录不存在，也不创建
        public boolean mkdirs()：创建文件目录，如果此文件目录的上层目录不存在，则一并创建

        删除硬盘中的文件或文件目录
        public boolean delete()：删除文件或文件目录（永久删除），如果当前对象是文件目录，要想删除成，则此文件目录下不能有文件或文件目录
     */
    @Test
    public void test7() throws IOException {
        //  文件的创建
        File file1 = new File("hei.txt");
        if (file1.exists()) {
            //  文件存在，则删除
            boolean delete = file1.delete();
            if (delete) {
                System.out.println("删除成功");
            }

        }
        //  删除后，再创建
        boolean createNewFile = file1.createNewFile();
        if (createNewFile) {
            System.out.println("创建成功");
        }
    }

    @Test
    public void test8() {
        //  文件目录的创建
        File file1 = new File("/Users/liudelong/Desktop/note/ATGuiguJava/io_test");
        if (file1.exists()) {
            boolean delete = file1.delete();
            if (delete) {
                System.out.println("删除成功");
            }
        }
        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        }

        File file2 = new File("/Users/liudelong/Desktop/note/ATGuiguJava/io_test1/io_test/io");
        if (file2.exists()) {
            boolean delete = file2.delete();
            if (delete) {
                System.out.println("删除成功");
            }
        }
        boolean mkdirs = file2.mkdirs();
        if (mkdirs) {
            System.out.println("创建成功");
        }

    }
}
