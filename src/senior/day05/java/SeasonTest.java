package senior.day05.java;

/*
    一.枚举类的使用：
    1.枚举类的理解：当一个类的对象只有有限个、确定的。我们称此类为枚举类
    2.当需要定义一组常量时，强烈建议使用枚举类
    3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式

    二.如何定义枚举类：
    方式1：jdk5.0之前，自定义枚举类
    方式2：jdk5.0时，使用enum关键字定义枚举类

    三.Enum中的常用方法：
    values()：返回枚举类型的对象数组，该方法可以很方便地遍历所有枚举值
    valueOf(String str)：通过字符串，生成对应的枚举类对象，
                        要求字符串必须是枚举类对象的名字，否则会抛出异常java.lang.IllegalArgumentException
    toString()：返回当前枚举类对象常量的名称
    ordinal()：返回当前枚举类对象常量的索引（定义的顺序）

    四：使用enum关键字定义的枚举类实现接口的情况：
    情况1.实现接口，在enum类中实现抽象方法
    情况2.
 */

//  jdk5.0之前自定义枚举类的方式
class Season {
    //  声明Season的属性（如果需要）
    private final String seasonName;
    private final String seasonDescription;

    //  提供枚举类的多个对象
    public static final Season SPRING = new Season("春", "春暖花开");
    public static final Season SUMMER = new Season("夏", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋", "秋高气爽");
    public static final Season WINTER = new Season("冬", "冰天雪地");

    //  私有化构造器
    private Season(String seasonName, String seasonDescription) {
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDescription() {
        return seasonDescription;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDescription='" + seasonDescription + '\'' +
                '}';
    }
}

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println(spring.getSeasonName());
        System.out.println(spring.getSeasonDescription());
    }
}
