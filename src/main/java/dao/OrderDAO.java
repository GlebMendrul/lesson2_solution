package dao;

import domains.Order;
import util.Storage;

import java.util.*;

/**
 * Created by gleb on 25.11.15.
 */
public class OrderDAO implements IOrderDAO {

    private Storage storage;

    public Order getById(String orderId) {
        List<Order> orders = storage.getOrders();
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOlderThanDate(Date date) {
        List<Order> orders = storage.getOrders();
        List<Order> result = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.getPurchaseDate().after(date)) {
                result.add(order);
            }
        }
        return result;
    }

    public Map<Date, List<Order>> getOrdersByDate() {
        List<Order> orders = storage.getOrders();
        Map<Date, List<Order>> result = new HashMap<Date, List<Order>>();
        for (Order order : orders) {
            if (result.containsKey(order.getPurchaseDate())) {
                result.get(order.getPurchaseDate()).add(order);
            } else {
                List<Order> t = new ArrayList<Order>();
                t.add(order);
                result.put(order.getPurchaseDate(), t);
            }
        }
        return result;
    }

    public Set<Order> getUniqueOrders() {
        List<Order> orders = storage.getOrders();
        return new HashSet<Order>(orders);
    }

    public List<Order> getSortedOrders() {
        List<Order> orders = storage.getOrders();
        Collections.sort(orders, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return o1.getPurchaseDate().compareTo(o2.getPurchaseDate());
            }
        });
        return orders;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

}
