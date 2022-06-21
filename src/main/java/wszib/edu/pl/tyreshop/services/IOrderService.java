package wszib.edu.pl.tyreshop.services;

import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;


import java.util.List;

public interface IOrderService {
    List<Order> findOrdersByUser(User user);


}
