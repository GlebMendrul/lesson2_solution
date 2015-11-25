package dao;

import domains.Order;
import util.Storage;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gleb on 25.11.15.
 */
public interface IOrderDAO {

    Order getById(String orderId);

    List<Order> getOlderThanDate(Date date);

    Map<Date, List<Order>> getOrdersByDate();

    Set<Order> getUniqueOrders();

    List<Order> getSortedOrders();

    void setStorage(Storage storage);
}
