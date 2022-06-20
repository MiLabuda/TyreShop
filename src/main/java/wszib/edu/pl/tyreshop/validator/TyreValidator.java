package wszib.edu.pl.tyreshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import wszib.edu.pl.tyreshop.model.Tyre;

@Component
public class TyreValidator implements Validator {

    private final String  ERROR_EMPTY = "This field can't be empty";

    @Override
    public boolean supports(Class<?> clazz) {
        return Tyre.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tyre tyre = (Tyre) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ean", ERROR_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tyreManufacturer", ERROR_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "TyreModel", ERROR_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tyreWidth", ERROR_EMPTY);
    }
}
