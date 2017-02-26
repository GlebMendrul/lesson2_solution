package util;

import domains.Order;
import lombok.Data;

import java.util.List;

/**
 * Created by gleb on 25.11.15.
 */
@Data
public class Storage {
    private List<Order> orders;
}
