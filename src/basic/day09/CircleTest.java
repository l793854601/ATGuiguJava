package basic.day09;

/*
    定义一个Circle类，包含一个double型的radius属性代表圆的半径
    一个findArea方法返回圆的面积

    定义一个类PassObject，在类中定UI一个方法printAreas，该方法的定义如下
    public void printAreas(Circle c, int times)
    在printAreas方法中打印输出1到time之间的每一个证书般精致，以及对应的面积
    例如：times为5，则输出半径为1、2、3、4、5，以及对应的圆面积

    在main方法中调用printAreas方法，调用完毕后输出当前半径值
 */

class Circle {
    double radius;

    public double findArea() {
        return radius * radius * Math.PI;
    }
}

class PassObject {
    public void printAreas(Circle c, int times) {
        System.out.println("Radius\t\tArea");
        for (int i = 1; i <= times; i++) {
            c.radius = i;
            System.out.println(c.radius + "\t\t\t" + c.findArea());
        }
        c.radius = times + 1;
        System.out.println("new radius is: " + c.radius);
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject object = new PassObject();
        object.printAreas(c, 5);
    }
}
