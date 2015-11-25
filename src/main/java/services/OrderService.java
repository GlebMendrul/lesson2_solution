package services;

import dao.IOrderDAO;
import domains.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gleb on 25.11.15.
 */
public class OrderService {

    private IOrderDAO orderDAO;

    public OrderService(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order getById(String orderId) {
        return orderDAO.getById(orderId);
    }

    public List<Order> getOlderThanDate(Date date) {
        return orderDAO.getOlderThanDate(date);
    }

    public Map<Date, List<Order>> getOrdersByDate() {
        return orderDAO.getOrdersByDate();
    }

    public Set<Order> getUniqueOrders() {
        return orderDAO.getUniqueOrders();
    }

    public List<Order> getSortedOrders() {
        return orderDAO.getSortedOrders();
    }

}
