package senior.day12.java4;

public class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Boy{");
        sb.append("girl=").append(girl);
        sb.append('}');
        return sb.toString();
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
