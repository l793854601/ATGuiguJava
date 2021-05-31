package basic.day15.exer3;

public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {

    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle circle = (ComparableCircle) o;
            double offset = getRadius() - circle.getRadius();
            if (offset > 0) {
                return 1;
            } else if (offset < 0) {
                return -1;
            }
            return 0;
        }
        return 0;
    }
}
