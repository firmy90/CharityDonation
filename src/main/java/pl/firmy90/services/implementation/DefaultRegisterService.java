package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.Role;
import pl.firmy90.model.domain.entity.User;
import pl.firmy90.model.repositories.RegistrationRepository;
import pl.firmy90.services.interfaces.RegisterService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    }

    @Override
    public void registerAdmin(RegistrationDTO registrationDTO) {
        log.debug("Registration data to create user: {}", registrationDTO);
        User user = modelMapper.map(registrationDTO, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        String encdodedPswd = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(encdodedPswd);
        user.setVisible(Boolean.TRUE);
        user.setRole(Role.ROLE_ADMIN);
        log.debug("User before action save: {}", user);
        registrationRepository.save(user);

    }

    @Override
    public List<RegistrationDTO> showActiveUsersByRole(Role role) {
        List<User> users = registrationRepository.findByRoleEqualsAndVisibleEquals(role, Boolean.TRUE);
        log.debug("Users list: {}", users.toString());
        return users.stream().map(user -> modelMapper.map(user, RegistrationDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RegistrationDTO findById(Long id) {
        Optional<User> byId = registrationRepository.findById(id);
        RegistrationDTO map = modelMapper.map(byId.get(), RegistrationDTO.class);
        map.setPassword(null);
        log.debug("Admin from id: {}", map.toString());
        return map;
    }

    @Override
    public boolean update(Long id, RegistrationDTO registrationDTO, Role role) {
        Optional<User> userOptional = registrationRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            modelMapper.map(registrationDTO, user);
            user.setId(id);
            user.setRole(role);
            String encdodedPswd = passwordEncoder.encode(registrationDTO.getPassword());
            user.setPassword(encdodedPswd);
            log.debug("User after mapping: {}", user);
            registrationRepository.save(user);
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Long id) {
        Optional<User> userOptional = registrationRepository.findById(id);
        if (userOptional.isPresent()) {
            registrationRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean archive(Long id) {
        Optional<User> userOptional = registrationRepository.findById(id);
        if (userOptional.isPresent()) {
            registrationRepository.archiveById(userOptional.get().getId());
            return true;
        }
        return false;
    }
}
