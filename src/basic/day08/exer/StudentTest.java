package basic.day08.exer;

/*
    定义类Student，包含三个属性：学号number（int）、年纪state（int）、成绩score（int）
    创建20个学生对象，学号为1到20，年纪和成绩都有随机数确定
    问题1：打印出3年纪（state为3）的学生信息
    问题2：按学生成绩排序，并遍历所有学生信息
 */

import java.util.Arrays;
import java.util.Comparator;

class Student {
    int number;
    int state;
    int score;

    public String getInfo() {
        String info = "Student " + number + " state: " + state + ", score: " + score;
        return info;
    }
}

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            student.number = i + 1;
            student.state = (int) (Math.random() * (6 - 1 + 1) + 1);
            student.score = (int) (Math.random() * 100);
            students[i] = student;
         }

        //  问题1：打印出3年纪（state为3）的学生信息
        StudentTest test = new StudentTest();
        test.showStudents(students, 3);

        System.out.println();

        //  问题2：按学生成绩排序，并遍历所有学生信息
        test.sortStudents(students);
    }

    public void showStudents(Student[] students, int state) {
        for (Student student : students) {
            if (student.state == state) {
                System.out.println(student.getInfo());
            }
        }
    }

    public void sortStudents(Student[] students) {
        Arrays.sort(students, (s1, s2) -> s1.score - s2.score);
        for (Student student : students) {
            System.out.println(student.getInfo());
        }
    }
}
