package pl.firmy90.dtos;

import lombok.Data;
import pl.firmy90.validation.constraints.SamePasswordsChangeUserData;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@SamePasswordsChangeUserData
public class ChangeUserDataDTO {
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Size(min = 8, max = 100)
    private String password;
    @NotBlank
    @Size(min = 8, max = 100)
    private String password2;
}
