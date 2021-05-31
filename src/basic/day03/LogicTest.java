package basic.day03;

/*
    运算符之四：逻辑运算符
    & && | || ! ^

    说明：
    1.逻辑运算符操作的都是boolean类型的变量
 */

public class LogicTest {
    public static void main(String[] args) {

        //  开发中，推荐使用&&、||

        //  区分& 与 &&
        //  相同点1：&与&&的运算结果相同
        //  相同点2：当符号左边为true时，二者都会执行符号右边的运算
        //  不同点：当符号左边是false时，&会继续执行符号右边的运算，&&不再执行符号右边的运算
        boolean b1 = false;
        int num1 = 10;
        if (b1 & (num1++ > 0)) {    //  &无短路效果，即使&左侧为false，也会执行&右侧语句
            System.out.println("北京");
        } else {
            System.out.println("南京");
        }

        System.out.println(num1);

        boolean b2 = false;
        int num2 = 10;
        if (b2 && (num2++ > 0)) {   //  &&有短路效果，如果&&左侧为false，那&&右侧语句不会执行
            System.out.println("北京");
        } else {
            System.out.println("南京");
        }

        System.out.println(num2);

        //  区分：| 与 ||
        //  相同点1：|与||的运算结果相同
        //  相同点2：当符号左边为false时，二者都会执行符号右边的运算
        //  不同点：当符号左边是true时，|会继续执行符号右边的运算，||不再执行符号右边的运算
        boolean b3 = true;
        int num3 = 10;
        if (b3 | (num3++ > 0)) {    //  |无短路效果，即使|左侧为true，也会执行|右侧语句
            System.out.println("北京");
        } else {
            System.out.println("南京");
        }

        System.out.println(num3);

        boolean b4 = true;
        int num4 = 10;
        if (b4 || (num4++ > 0)) {   //  ||有短路效果，如果&||左侧为true，那||右侧语句不会执行
            System.out.println("北京");
        } else {
            System.out.println("南京");
        }

        System.out.println(num4);
    }
}
