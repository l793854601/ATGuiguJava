package basic.day09;

public class ValueTransferTest2 {
    public static void main(String[] args) {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println("交换前：m = " + data.m + ", n = " + data.n);

        ValueTransferTest2 test = new ValueTransferTest2();
        test.swap(data);
        System.out.println("交换后：m = " + data.m + ", n = " + data.n);
    }

    public void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data {
    int m;
    int n;
}
