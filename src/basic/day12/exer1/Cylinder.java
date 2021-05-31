package basic.day12.exer1;

public class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume() {
        return super.findArea() * length;
    }

    @Override
    public double findArea() {  //  返回圆柱的表面积
        return super.findArea() * 2 + length * Math.PI * 2 * getRadius();
    }
}
