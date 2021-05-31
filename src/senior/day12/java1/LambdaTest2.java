package senior.day12.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
    Java内置的4大核心函数式接口：
    消费型接口：Consumer<T>       void accept(T t)
    生产型接口：Supplier<T>       T get()
    函数型接口：Function<T, R>    R apply(T t)
    断定型接口：Predicate<T>      boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为：" + aDouble);
            }
        });

        happyTime(400, money -> System.out.println("学习太累了，去天上人间喝了口水，价格为：" + money));
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");

        List<String> r1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(r1);

        List<String> r2 = filterString(list, s -> s.contains("京"));
        System.out.println(r2);
    }

    public List filterString(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }

        return result;
    }
}
