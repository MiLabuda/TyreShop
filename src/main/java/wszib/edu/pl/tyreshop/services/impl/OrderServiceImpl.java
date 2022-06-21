package wszib.edu.pl.tyreshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.services.IOrderService;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IUserService userService;


    @Autowired
    public OrderServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Order> findOrdersByUser(User user) {
        return null;
    }

}
