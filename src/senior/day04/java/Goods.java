package senior.day04.java;

public class Goods implements Comparable<Goods> {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //  指明商品比较大小的方式：按照价格从低到高排序，再按照名称从小到大排序
    @Override
    public int compareTo(Goods o) {
        if (o == null) {
            return 1;
        }
        int priceCompare = Double.compare(price, o.getPrice());
        if (priceCompare != 0) {
            return priceCompare;
        }
        return name.compareTo(o.getName());
    }


}
