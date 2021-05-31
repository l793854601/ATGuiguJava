package basic.day08.exer;

/*
    利用变相对象的编程方法，设计类Circle计算圆的面积
 */

class Circle {
    /**
     * 半径
     */
    double radius;

    /**
     * 计算面积
     * @return
     */
    public double getArea() {
        double area = radius * radius * Math.PI;
        return area;
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 10;
        double area = c1.getArea();
        System.out.println(area);
    }
}
