package wszib.edu.pl.tyreshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.model.dto.OrderDto;
import wszib.edu.pl.tyreshop.repository.IOrderRepository;
import wszib.edu.pl.tyreshop.services.IOrderService;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private IUserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, IUserService userService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Order> findOrdersByUser(User user) {
        return this.orderRepository.findOrderByUser(user);
    }

    @Override
    public void cancelOrder(OrderDto orderDto) {
    this.orderRepository.cancelOrderByOrderId(orderDto.getOrderId().longValue());
    }

    @Override
    public void saveOrder(OrderDto orderDto) {

    }
}
