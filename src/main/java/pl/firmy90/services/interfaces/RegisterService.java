package pl.firmy90.services.interfaces;

import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.Role;

import java.util.List;

public interface RegisterService {
    void register(RegistrationDTO registrationDTO);

    void registerAdmin(RegistrationDTO registrationDTO);

    List<RegistrationDTO> showActiveUsersByRole(Role role);

    RegistrationDTO findById(Long id);

    boolean update(Long id, RegistrationDTO registrationDTO, Role role);
    boolean delete(Long id);
    boolean archive(Long id);
}
