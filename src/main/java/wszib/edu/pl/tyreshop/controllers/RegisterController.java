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
public class RegisterController {
    private final IUserService userService;
    private final UserValidator userValidator;

    @Autowired
    public RegisterController(IUserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "register";
        }

        userService.save(userForm);
        userService.login(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/main";
    }

}
