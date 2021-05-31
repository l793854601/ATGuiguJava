package senior.day12.java4;

import org.junit.Test;

import java.util.Optional;

/*
    Optional：为了在程序中避免出现空指针异常而创建的

    Optional API的使用
    Optional.of(T t)：创建一个Optional实例，t必须非null
    Optional.empty()：创建一个Optional实例，其内容为null
    Optional.ofNullable(T t)：创建一个Optional实例，t可以为null
 */
public class OptionalTest {
    @Test
    public void test1() {
        Girl girl = new Girl();
        //  of(T t)：保证t是非空的
        Optional<Girl> optional = Optional.of(girl);
    }

    @Test
    public void test2() {
        Girl girl = null;
        //  ofNullable(T t)：t可以是null
        Optional<Girl> optional = Optional.ofNullable(null);
        System.out.println(optional);
        //  orElse(T t)：如果当前的Optional内部封装的t是非空的，则返回内部的t
        Girl girl1 = optional.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
//        String girlName = getGirlName(boy);
        String girlName = getGirlName1(boy);
        System.out.println(girlName);

        getGirlName1(boy);
    }

    /*
        如果不做处理，则会抛出java.lang.NullPointerException
     */
    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    /*
        使用if判断，避免抛出java.lang.NullPointerException
     */
    public String getGirlName1(Boy boy) {
        if (boy == null) {
            return null;
        }
        Girl girl = boy.getGirl();
        if (girl == null) {
            return null;
        }
        return girl.getName();
    }

    @Test
    public void test4() {
        Boy boy = null;
        boy = new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    /*
        使用Optional类，避免抛出java.lang.NullPointerException
     */
    public String getGirlName2(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        //  boy1一定非空，但boy.getGirl()可能为空
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = Optional.ofNullable(boy1.getGirl()).orElse(new Girl("古力娜扎"));
        return girl.getName();
    }
}
