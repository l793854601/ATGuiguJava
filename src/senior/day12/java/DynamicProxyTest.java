package senior.day12.java;

/*
    动态代理的举例
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//  接口
interface Human {
    String getBelief();
    void eat(String food);
}

//  被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("通用方法1");
    }

    public void method2() {
        System.out.println("通用方法2");
    }
}

/*
    要想生成动态代理，需要解决的问题：
    1.如何根据加载到内存中的被代理类，动态地创建一个代理类及其对象
    2.当通过代理类的对象调用方法时，如何动态地调用被代理类中的同名方法
 */

class ProxyFactory {

    /**
     * 调用此方法，返回一个代理类的对象
     * @param object 被代理类的对象
     * @return
     */
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        handler.bind(object);
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    //  被代理类对象
    private Object object;

    //`设置被代理类对象
    public void bind(Object object) {
        this.object = object;
    }

    //  当我们通过代理类的对象调用方法a时，就会自动地调用invoke()
    //  将被代理类要执行的方法a的功能，声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //  method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //  object：被代理类的对象
        Object returnValue = method.invoke(object, args);

        util.method2();

        //  上述方法的返回值就作为当前类中的invoke()方法的返回值
        return returnValue;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //  proxyInstance即为代理类
        Human human = (Human) ProxyFactory.getProxyInstance(superMan);
        //  当通过代理类对象调用方法时，会自动调用被代理类中同名的方法
        System.out.println(human.getBelief());
        human.eat("四川麻辣烫");

        System.out.println();

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        clothFactory.produceCloth();
    }
}
