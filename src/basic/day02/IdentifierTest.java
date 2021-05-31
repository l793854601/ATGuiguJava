package basic.day02;

/*
    1.标识符：java对各种变量、方法、接口、类、包名等要素命名时所使用的字符序列成为标识符
    技巧：凡是自己可以起名字的元素，都叫标识符

    2.定义合法标识符规则：
    由26个英文字母大小写、数字0~9、下划线_或者$组成
    数字不可以开头
    不可以使用关键字和保留字，但可以包含关键字和保留字
    Java严格区分大小写，长度无限制
    标识符不能包含空格

    3.java中的命名规范：
    包名：多单词组成a
    注意：
    在起名字时，为了提高阅读性，要尽量有意义，"见名知意思"
    java采用unicode字符集，因此标识符也可以使用汉字声明，但是不建议使用
 */

public class IdentifierTest {
    public static void main(String[] args) {
        int myNumber = 1001;
        System.out.println(myNumber);

        //  可以，但不建议使用中文命名标识符
        int 一个变量 = 10;
        System.out.println(一个变量);
    }
}

class Hello_$1 {

}

class Public {

}

class PublicStatic {

}
