package dao;

import domains.Order;
import util.Storage;

import java.util.*;

/**
 * Created by gleb on 25.11.15.
 */
public interface IOrderDAO {

    Optional<Order> getById(String orderId);

    List<Order> getOlderThanDate(Date date);

    Map<Date, List<Order>> getOrdersByDate();

    Set<Order> getUniqueOrders();

    List<Order> getSortedOrders();

    void setStorage(Storage storage);
}
