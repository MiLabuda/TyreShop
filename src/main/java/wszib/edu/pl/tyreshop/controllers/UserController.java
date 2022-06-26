package wszib.edu.pl.tyreshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.services.IUserService;


import java.security.Principal;

@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPanel(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());

        if(user != null) {
            model.addAttribute("user", user);
        }else{
            return "error/404";
        }
        return "user";
    }

}
