package domains;

import java.util.Date;

/**
 * Created by gleb on 25.11.15.
 */
public class Order {

    private String desc;
    private Date purchaseDate;
    private String orderId;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return !(orderId != null ? !orderId.equals(order.orderId) : order.orderId != null);

    }

    @Override
    public int hashCode() {
        return orderId != null ? orderId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "desc='" + desc + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
