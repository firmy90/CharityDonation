package pl.firmy90.validation.validators;

import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidator implements ConstraintValidator<SamePasswords, RegistrationDTO> {
    @Override
    public void initialize(SamePasswords constraintAnnotation) {

    }

    @Override
    public boolean isValid(RegistrationDTO registrationDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (registrationDTO.getPassword() == null || registrationDTO.getPassword2() == null) {
            return true;
        }
        boolean valid =  registrationDTO.getPassword2().equals(registrationDTO.getPassword());
        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("SamePasswords.registrationData.password2")
                    .addPropertyNode("password2").addConstraintViolation();
        }
        return valid;

    }
}
