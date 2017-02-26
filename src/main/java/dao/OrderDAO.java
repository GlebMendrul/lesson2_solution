package dao;

import domains.Order;
import lombok.Getter;
import lombok.Setter;
import util.Storage;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by gleb on 25.11.15.
 */
public class OrderDAO implements IOrderDAO {

    @Getter
    @Setter
    private Storage storage;

    public Optional<Order> getById(String orderId) {
        List<Order> orders = storage.getOrders();
        return orders.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst();
    }

    public List<Order> getOlderThanDate(Date date) {
        List<Order> orders = storage.getOrders();
        return orders.stream().filter(order -> order.getPurchaseDate().after(date)).collect(toList());
    }

    public Map<Date, List<Order>> getOrdersByDate() {
        List<Order> orders = storage.getOrders();
        return orders.stream().collect(groupingBy(Order::getPurchaseDate));
    }

    public Set<Order> getUniqueOrders() {
        List<Order> orders = storage.getOrders();
        return new HashSet<>(orders);
    }

    public List<Order> getSortedOrders() {
        List<Order> orders = storage.getOrders();
        orders.sort(Comparator.comparing(Order::getPurchaseDate));
        return orders;
    }

}
