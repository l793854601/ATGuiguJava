package basic.day13.java1;

public class Customer {
    private String name;
    private int age;

    public Customer() {

    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {    //  此处一定要判断o是否为null，否则可能会抛出空指针异常
            return false;
        }
        if (o instanceof Customer) {
            Customer customer = (Customer) o;
            return age == customer.age && name.equals(customer.name);
        }
        return false;

        //  idea默认生成的equals方法
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return age == customer.age && Objects.equals(name, customer.name);
    }

    //  编译器生成equals方法的同时，也会生成hashCode方法
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }


    @Override
    public String toString() {
        return "Customer{name = " + name + ", age = " + age + "}";

        //  idea默认生成的toString方法
//        return "Customer{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
    }
}
