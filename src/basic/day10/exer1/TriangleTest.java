package basic.day10.exer1;

/*
    编写两个类：Triangle、TriangleTest，
    其中Triangle类中高胜美私有的底边唱base和高height，同时声明公共方法访问私有变量（set、get）
    此外，提供类必要的构造器，另一个类中使用这些公共方法，计算三角形的面积
 */

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10, 20);
        System.out.println(triangle.getArea());

        Triangle triangle1 = new Triangle();
        triangle1.setBase(5);
        triangle1.setHeight(4);
        System.out.println(triangle1.getArea());
    }
}
