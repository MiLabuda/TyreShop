package wszib.edu.pl.tyreshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.services.IUserService;
import wszib.edu.pl.tyreshop.validator.UserValidator;

@Controller
public class LoginCotroller {

    private final IUserService userService;

    @Autowired
    public LoginCotroller(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null)
            model.addAttribute("error", "Your username or password is invalid");
            return "login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        userService.login(user.getUsername(), user.getPassword());


        return "redirect:/main";
    }
}
