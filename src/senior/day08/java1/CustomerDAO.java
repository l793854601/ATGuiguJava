package senior.day08.java1;

import java.util.List;

public class CustomerDAO extends DAO<Customer> {    //  只能操作Customer

    @Override
    public void add(Customer customer) {

    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public void update(int index, Customer customer) {

    }

    @Override
    public Customer get(int index) {
        return null;
    }

    @Override
    public List<Customer> get(int... index) {
        return null;
    }
}
