package wszib.edu.pl.tyreshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wszib.edu.pl.tyreshop.model.Tyre;
import wszib.edu.pl.tyreshop.model.dto.UserDto;
import wszib.edu.pl.tyreshop.services.IOrderService;
import wszib.edu.pl.tyreshop.services.ITyreService;
import wszib.edu.pl.tyreshop.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/tyreshop")
public class CommonController {

    private IUserService userService;
    private ITyreService tyreService;
    private IOrderService orderService;

    @Autowired
    public CommonController(IUserService userService, ITyreService tyreService, IOrderService orderService) {
        this.userService = userService;
        this.tyreService = tyreService;
        this.orderService = orderService;
    }

    @GetMapping
    public List<Tyre> landingPage() {
        return this.tyreService.getAllTyres();
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/tyres")
    public List<Tyre> getAllTyres(){
        return this.tyreService.getAllTyres();
    }


}
