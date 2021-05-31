package senior.day08.java1;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        Customer customer = dao1.get(1);
        List<Customer> customers = dao1.get(1, 2, 3);

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        Student student = dao2.get(1);
        List<Student> students = dao2.get(1, 2, 3);
    }
}
