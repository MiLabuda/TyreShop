package wszib.edu.pl.tyreshop.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.model.dto.OrderDto;
import wszib.edu.pl.tyreshop.model.dto.UserDto;
import wszib.edu.pl.tyreshop.repository.IUserRepository;
import wszib.edu.pl.tyreshop.services.IOrderService;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;

@RestController
public class UserController {

    private IUserRepository userRepository;
    private IOrderService orderService;
    private IUserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(IUserRepository userRepository, IOrderService orderService, IUserService userService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.orderService = orderService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/orders")
    public List<Order> getOrders(@RequestBody UserDto userDto) {
        User user = this.userRepository.findByUsername(userDto.getUsername());

        return this.orderService.findOrdersByUser(user);
    }

    @DeleteMapping("/orders/cancel")
    public void cancelOrder(@RequestBody OrderDto orderDto){
        this.orderService.cancelOrder(orderDto);
    }


}
