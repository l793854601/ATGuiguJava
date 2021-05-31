package basic.day12.exer;

public class KidsTest {
    public static void main(String[] args) {
        Kids kids = new Kids(12);
        kids.printAge();

        kids.setSalary(0);
        kids.employeed();

        kids.setSex(1);
        kids.manOrWoman();
    }
}
