package basic.day15.java1;

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {

    private String name;

    public Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void play() {
        //  接口中定义的变量，为全局常量，此处不可修改
//        ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}

public class PlayableTest {
}
