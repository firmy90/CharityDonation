package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.firmy90.model.repositories.RegistrationRepository;
import pl.firmy90.services.interfaces.ValidationService;

@AllArgsConstructor
@Getter
@Setter
@Slf4j
@Service
public class DefaultValidationService implements ValidationService {
    private final RegistrationRepository userRepository;

    @Override
    public boolean isUniqueUsername(String username) {

        return !userRepository.existsByUsername(username);
    }
}
