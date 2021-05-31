package basic.day16.java2;

class Student {
    private int id;

    public void register(int id) throws MyException {
        if (id <= 0) {
            //  手动抛出一个异常对象
//            throw new RuntimeException("您输入的数据非法！");
            throw new MyException("您输入的数据非法！");
        }
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.register(-1001);
            System.out.println(student);
        } catch (MyException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
