package basic.day15.exer;

/*
    定义一个测试类GeometricTest
    编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，体用动态绑定技术）
    编写一个displayGeometricObject方法显示对象的面积（注意方法的参数类型，体用动态绑定技术）
 */

public class GeometricTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.3, "white", 1.0);
        Circle c2 = new Circle(3.3, "white", 1.0);
        Circle c3 = new Circle(3.3, "white", 1.0);

        GeometricTest test = new GeometricTest();

        test.displayGeometricObject(c1);
        test.displayGeometricObject(c2);
        test.displayGeometricObject(c3);

        System.out.println("c1与c2的面积是否相等：" + test.equalsArea(c1, c2));
        System.out.println("c2与c3的面积是否相等：" + test.equalsArea(c2, c3));

        MyRectangle r1 = new MyRectangle(1, 4, "red", 1.0);
        MyRectangle r2 = new MyRectangle(2, 2, "red", 1.0);

        test.displayGeometricObject(r1);
        test.displayGeometricObject(r2);

        System.out.println("r1与r2的面积是否相等：" + test.equalsArea(r1, r2));
    }

    public boolean equalsArea(GeometricObject o1, GeometricObject o2) {
        return o1.findArea() == o2.findArea();
    }

    public void displayGeometricObject(GeometricObject geometricObject) {
        System.out.println("面积为：" + geometricObject.findArea());
    }
}
