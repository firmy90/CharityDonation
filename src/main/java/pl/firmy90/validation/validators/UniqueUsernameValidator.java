package pl.firmy90.validation.validators;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.firmy90.services.interfaces.ValidationService;
import pl.firmy90.validation.constraints.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
@Getter
@Setter
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final ValidationService validationService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (username == null) {
            return true;
        }
        return validationService.isUniqueUsername(username);
    }
}
