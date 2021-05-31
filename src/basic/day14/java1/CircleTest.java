package basic.day14.java1;

/*
    static关键字的应用
 */

class Circle {
    private double radius;
    private int id;

    private static int total;
    private static int init = 1001;

    public Circle() {
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle(12.0);
        System.out.println(c1.getId());
        System.out.println(c2.getId());
        System.out.println(c3.getId());
        System.out.println(Circle.getTotal());
    }
}
