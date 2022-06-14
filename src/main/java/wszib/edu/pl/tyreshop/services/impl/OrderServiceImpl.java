package wszib.edu.pl.tyreshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.model.dto.OrderDto;
import wszib.edu.pl.tyreshop.services.IOrderService;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IUserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(IUserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Order> findOrdersByUser(User user) {
        return null;
    }

    @Override
    public void cancelOrder(OrderDto orderDto) {

    }

    @Override
    public void saveOrder(OrderDto orderDto) {

    }
}
