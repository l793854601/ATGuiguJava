package senior.day12.java2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1001, "马化腾", 34, 6000.38));
        employees.add(new Employee(1002, "马云", 12, 9876.12));
        employees.add(new Employee(1003, "刘强东", 33, 3000.82));
        employees.add(new Employee(1004, "雷军", 26, 7654.37));
        employees.add(new Employee(1005, "李彦宏", 65, 5555.32));
        employees.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
        employees.add(new Employee(1007, "任正非", 26, 4333.32));
        employees.add(new Employee(1008, "扎克伯格", 35, 2500.32));
        return employees;
    }
}
