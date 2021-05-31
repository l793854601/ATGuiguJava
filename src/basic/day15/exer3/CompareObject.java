package basic.day15.exer3;

public interface CompareObject {
    /**
     * 比较元素的大小
     * @param o
     * @return 0：相等，正数：当前对象较大，负数：当前对象较小
     */
    int compareTo(Object o);
}
