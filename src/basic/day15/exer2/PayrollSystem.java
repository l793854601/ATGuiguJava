package basic.day15.exer2;

/*
    定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用
    利用循环结构遍历数组元素，输出各个对象的类型、name、number、birthday、以及该对象生日
    当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息
 */

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {

        //  使用Calendar获取月份
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);
        System.out.println("当前月份为：" + currentMonth + 1);    //  从0开始，1月份为0

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当月月份：");
        int month = scanner.nextInt();

        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("马森", 1002, new MyDate(1992, 2, 28), 10000);
        employees[1] = new HourlyEmployee("潘雨生", 2001, new MyDate(1991, 5, 6), 60, 240);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            System.out.println("月工资为：" + employees[i].earnings());

            if (month == employees[i].getBirthday().getMonth()) {
                System.out.println("生日快乐！奖励100元");
            }
        }
    }
}
