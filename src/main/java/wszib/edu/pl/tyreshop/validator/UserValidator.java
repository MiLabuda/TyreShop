package wszib.edu.pl.tyreshop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import wszib.edu.pl.tyreshop.model.User;
import wszib.edu.pl.tyreshop.services.IUserService;


@Component
public class UserValidator implements Validator {

    private final IUserService userService;

    @Autowired
    public UserValidator(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        //Username and password can't me empty or contain whitespace
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.not_empty");

        // Username must have from 4 characters to 32
        if (user.getUsername().length() < 4) {
            errors.rejectValue("username", "register.error.username.less_4");
        }
        if(user.getUsername().length() > 32){
            errors.rejectValue("username","register.error.username.over_32");
        }
        //Username can't be duplicated
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "register.error.duplicated.username");
        }
        //Email can't be duplicated
        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "register.error.duplicated.email");
        }
        //Password must have at least 8 characters and max 32
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "register.error.password.less_8");
        }
        if (user.getPassword().length() > 32){
            errors.rejectValue("password", "register.error.password.over_32");
        }
        //Password must be the same as the confirmation password
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "register.error.diff_password");
        }

    }
}
