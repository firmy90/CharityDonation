package pl.firmy90.validation.validators;

import pl.firmy90.dtos.ChangeUserDataDTO;
import pl.firmy90.validation.constraints.SamePasswordsChangeUserData;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordChangeUserValidator implements ConstraintValidator<SamePasswordsChangeUserData, ChangeUserDataDTO> {
    @Override
    public void initialize(SamePasswordsChangeUserData constraintAnnotation) {

    }

    @Override
    public boolean isValid(ChangeUserDataDTO registrationDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (registrationDTO.getPassword() == null || registrationDTO.getPassword2() == null) {
            return true;
        }
        boolean valid = registrationDTO.getPassword2().equals(registrationDTO.getPassword());
        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("SamePasswords.registrationData.password2")
                    .addPropertyNode("password2").addConstraintViolation();
        }
        return valid;

    }
}
