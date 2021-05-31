package basic.day04;

/*
    分支结构之二：switch-case

    1.格式
    switch (表达式) {
        case 常量1:
            执行语句1;
            break;
        case 常量2:
            执行语句2;
            break;
        case 常量3:
            执行语句3;
            break;
        ...
        default:
            执行语句N;
            break;  //  default中的break可以不加
    }

    2.说明：
      根据switch表达式中的值，依次匹配各个case中的常量，一旦匹配成功，则进入相应case结构中，调用其执行语句
      当调用完执行语句后，则仍然继续向下执行其他case结构中的执行语句，直到遇到break关键字或者switch-case结构末尾结束为止。

      break关键字可以使用在switch-case结构中，表示一旦执行到此关键字，就跳出switch-case结构

      switch-case结构中的表达式，只能是如下的6中数据类型之一：byte、short、char、int、枚举类型（JDK5.0）、String（JDK7.0）

      case之后只能声明常量，不能声明范围（某些编程语言，如swift可以）

      default：相当于if-else结构中的else
               default是可选的，而且位置是灵活的
 */

public class SwitchCaseTest {
    public static void main(String[] args) {

        int number = 2;
        switch (number) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Other");
                break;
        }

        String season = "summer";
        switch (season) {
            case "spring":
                System.out.println("春年花开");
                break;
            case "summer":
                System.out.println("夏日炎炎");
                break;
            case "autumn":
                System.out.println("秋高气爽");
                break;
            case "winter":
                System.out.println("冬雪皑皑");
                break;
            default:
                System.out.println("季节输入有误");
                break;
        }
    }
}
