package wszib.edu.pl.tyreshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import wszib.edu.pl.tyreshop.model.Order;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.model.dto.OrderDto;
import wszib.edu.pl.tyreshop.model.dto.UserDto;
import wszib.edu.pl.tyreshop.repository.IUserRepository;
import wszib.edu.pl.tyreshop.services.IOrderService;
import wszib.edu.pl.tyreshop.services.IUserService;


import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private IOrderService orderService;
    private IUserService userService;

    @Autowired
    public UserController(IOrderService orderService, IUserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @GetMapping

    @GetMapping("/login")
    public String loginForm(Model model) {
    }

    @PostMapping("/orders")
    public List<Order> getOrders(@RequestBody UserDto userDto) {
        User user = this.userService.getUserByUsername(userDto.getUsername());
        return this.orderService.findOrdersByUser(user);
    }

    @DeleteMapping("/orders/cancel")
    public void cancelOrder(@RequestBody OrderDto orderDto){
        this.orderService.cancelOrder(orderDto);
    }


}
