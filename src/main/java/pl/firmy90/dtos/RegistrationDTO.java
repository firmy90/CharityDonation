package pl.firmy90.dtos;

import lombok.Data;
import lombok.ToString;
import pl.firmy90.validation.constraints.SamePasswords;
import pl.firmy90.validation.constraints.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString(exclude = {"password","password2"})
@Data
@SamePasswords
public class RegistrationDTO {
        private String userId;
        @NotBlank
        @Size(min=3, max=100)
        private String name;
        @NotBlank
        private String surname;
        @NotBlank
        @Size(min=3, max=100)
        @Email
        @UniqueUsername
        private String username;
        @NotBlank
        @Size(min=8, max=100)
        private String password;
        @NotBlank
        @Size(min=8, max=100)
        private String password2;
}
