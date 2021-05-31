package senior.day08.java1;

import java.util.List;

public class StudentDAO extends DAO<Student> {  //  只能操作Student
    @Override
    public void add(Student student) {

    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public void update(int index, Student student) {

    }

    @Override
    public Student get(int index) {
        return null;
    }

    @Override
    public List<Student> get(int... index) {
        return null;
    }
}
