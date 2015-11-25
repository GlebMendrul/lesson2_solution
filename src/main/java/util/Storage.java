package util;

import domains.Order;

import java.util.List;

/**
 * Created by gleb on 25.11.15.
 */
public class Storage {

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Storage{" +
                ", orders=" + orders +
                '}';
    }
}
