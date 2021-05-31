package senior.day12.java;

/*
     静态代理的举例
     特点：代理类与被代理类，在编译期间就确定下来了
 */

import org.hamcrest.Factory;

//  接口
interface ClothFactory {
    void produceCloth();
}

//  代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//  被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //  创建被代理类对象
        NikeClothFactory nike = new NikeClothFactory();
        //  使用被代理类对象实例化代理类对象
        ProxyClothFactory factory = new ProxyClothFactory(nike);
        //  代理类调用produceCloth()方法，内部会调用被代理类对象的produceCloth()方法
        factory.produceCloth();
    }
}
