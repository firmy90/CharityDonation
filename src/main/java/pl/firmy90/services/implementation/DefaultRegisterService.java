package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.User;
import pl.firmy90.model.repositories.RegistrationRepository;
import pl.firmy90.services.interfaces.RegisterService;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultRegisterService implements RegisterService {
    private final ModelMapper modelMapper;
    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationDTO registrationDTO) {
        log.debug("Registration data to create user: {}", registrationDTO);
        User user = modelMapper.map(registrationDTO, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        String encdodedPswd = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(encdodedPswd);
        user.setVisible(Boolean.TRUE);
        log.debug("User before action save: {}", user);
        registrationRepository.save(user);
//        log.debug("User after action save: {} ", userRepository.findUserByUsername(user.getUsername()));

    }
}
