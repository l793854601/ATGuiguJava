package basic.day15.java1;

/*
    接口的应用：代理模式
    被代理类：真正实现业务的类
    代理类：外部包装类
 */

interface Network {
    void browse();
}

//  被代理类
class Server implements Network {
    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

//  代理类
class ProxyServer implements Network {

    private Network work;

    public ProxyServer(Network work) {
        this.work = work;
    }

    public void check() {
        System.out.println("联网直前的检查工作");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}

public class NetworkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}
