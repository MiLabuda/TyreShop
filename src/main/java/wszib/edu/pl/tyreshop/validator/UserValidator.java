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

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PASSWORD_CONFIRM = "passwordConfirm";
    private static final String EMAIL = "email";
    private static final Integer MIN = 4;
    private static final Integer MAX = 32;




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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME, "error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, "error.not_empty");

        if (user.getUsername().length() < MIN) {
            errors.rejectValue(USERNAME, "register.error.username.less_4");
        }
        if(user.getUsername().length() > MAX){
            errors.rejectValue(USERNAME,"register.error.username.over_32");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue(USERNAME, "register.error.duplicated.username");
        }
        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue(EMAIL, "register.error.duplicated.email");
        }
        if (user.getPassword().length() < MIN) {
            errors.rejectValue(PASSWORD, "register.error.password.less_4");
        }
        if (user.getPassword().length() > MAX){
            errors.rejectValue(PASSWORD, "register.error.password.over_32");
        }
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue(PASSWORD_CONFIRM, "register.error.diff_password");
        }
    }
}
