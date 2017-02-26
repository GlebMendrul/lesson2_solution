package domains;

import lombok.Data;

import java.util.Date;

/**
 * Created by gleb on 25.11.15.
 */
@Data
public class Order {
    private String desc;
    private Date purchaseDate;
    private String orderId;
}
