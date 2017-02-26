import dao.IOrderDAO;
import dao.OrderDAO;
import domains.Order;
import services.OrderService;
import util.Storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gleb on 25.11.15.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Storage storage = getStorage();
        IOrderDAO orderDAO = new OrderDAO();
        orderDAO.setStorage(storage);
        OrderService service = new OrderService(orderDAO);

        List<Order> sortedOrders = service.getSortedOrders();
        sortedOrders.forEach(System.out::println);
    }

    private static Storage getStorage() throws InterruptedException {
        Storage storage = new Storage();
        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setDesc("desc" + i);
            if (i % 2 == 0) {
                order.setPurchaseDate(new Date());
                order.setOrderId("orderId" + i);
            } else {
                Thread.sleep(500);
                order.setPurchaseDate(new Date());
                order.setOrderId("orderId");
            }
            orders.add(order);
            storage.setOrders(orders);
        }
        return storage;
    }
}
