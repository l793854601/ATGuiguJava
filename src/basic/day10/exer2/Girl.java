package basic.day10.exer2;

public class Girl {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry(Boy boy) {
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }

    /**
     * 比较两个对象的大小
     * @param girl
     * @return 正数：当前对象大，负数：当前对象小，0：当前对象与形参对象相等
     */
    public int compare(Girl girl) {
//        if (age > girl.age) {
//            return 1;
//        } else if (age < girl.age) {
//            return -1;
//        }
//        return 0;
        return age - girl.age;
    }
}
