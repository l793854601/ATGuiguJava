package basic.day10.exer4;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        customers = new Customer[1000];
    }

    public void addCustomer(String f, String l) {
        if (numberOfCustomer >= customers.length) { //  数组的length属性，是数组的容量，而不是数组中元素的个数
            //  参考ArrayList的扩容机制，应该扩容、复制数组
            //  在此先简单返回即可
            System.out.println("银行容量已满，无法添加客户！");
            return;
        }
        Customer customer = new Customer(f, l);
        customers[numberOfCustomer++] = customer;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        //  必须判断是否越界，且取出的元素不能为null
        if (index >= 0 && index < numberOfCustomer) {
            return customers[index];
        }
        return null;
    }
}
