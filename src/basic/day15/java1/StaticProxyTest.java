package basic.day15.java1;

interface Star {
    void confer();  //  面谈
    void singContract();    //  签合同
    void boolTicket();  //  订票
    void sing();    //  唱歌
    void collectMoney();    //  收钱
}

//  被代理类
class RealStar implements Star {

    @Override
    public void confer() {

    }

    @Override
    public void singContract() {

    }

    @Override
    public void boolTicket() {

    }

    @Override
    public void sing() {
        System.out.println("明星唱歌");
    }

    @Override
    public void collectMoney() {

    }
}

//  代理类
class Proxy implements Star {

    private Star star;

    public Proxy(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("经纪人面谈");
    }

    @Override
    public void singContract() {
        System.out.println("经纪人签合同");
    }

    @Override
    public void boolTicket() {
        System.out.println("经纪人订票");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        Star s = new Proxy(new RealStar());
        s.confer();
        s.singContract();
        s.boolTicket();
        s.sing();
        s.collectMoney();
    }
}
