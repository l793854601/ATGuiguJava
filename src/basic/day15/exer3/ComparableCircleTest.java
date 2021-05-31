package basic.day15.exer3;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);
        System.out.println(c1.compareTo(c2));
    }
}
