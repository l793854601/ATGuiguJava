package senior.day05.java;

/*
    使用enum关键字定义枚举类
    说明：定义的枚举类默认继承自java.lang.Enum类
 */

import java.util.Arrays;

interface Info {
    void show();
}

//  使用enum定义枚举类
enum Season1 implements Info {
    //  提供当前枚举类的对象，多个对象之间用英文逗号","隔开，末尾的对象用分号";"结束
    SPRING("春", "春暖花开") {
        @Override
        public void show() {
            System.out.println("这是一个春天");
        }
    },
    SUMMER("夏", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("这是一个夏天");
        }
    },
    AUTUMN("秋", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("这是一个秋天");
        }
    },
    WINTER("冬", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("这是一个冬天");
        }
    };

    //  声明Season的属性（如果需要）
    private final String seasonName;
    private final String seasonDescription;

    //  私有化构造器
    private Season1(String seasonName, String seasonDescription) {
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDescription() {
        return seasonDescription;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

    //    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDescription='" + seasonDescription + '\'' +
//                '}';
//    }
}

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(summer.getClass().getSuperclass());
        System.out.println(summer.ordinal());
        System.out.println(Arrays.toString(Season1.values()));
        System.out.println(Season1.valueOf("WINTER"));

        Season1.SPRING.show();
        Season1.WINTER.show();
    }
}
