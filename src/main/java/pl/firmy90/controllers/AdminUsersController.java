package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.firmy90.dtos.ChangeUserDataDTO;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.Role;
import pl.firmy90.services.interfaces.RegisterService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@Controller
@AllArgsConstructor
@Slf4j
public class AdminUsersController {
    private final RegisterService registerService;


    @GetMapping("users/add")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "register";
    }

    @PostMapping("users/add")
    public String registerUser(@ModelAttribute("registrationData") @Valid RegistrationDTO registrationDTO,
                               BindingResult results) {
        if (results.hasErrors()) {
            return "register";
        }
        registerService.register(registrationDTO);
        return "redirect:/admin/users";
    }

    @GetMapping("users")
    public String showAdmins(Model model) {
        List<RegistrationDTO> registrationDTOS = registerService.showActiveUsersByRole(Role.ROLE_USER);
        model.addAttribute("registrationData", registrationDTOS);
        return "admin/admin-users";
    }

    @GetMapping("users/edit/{id}")
    public String showUSerToEdit(@PathVariable Long id, Model model) {
        RegistrationDTO byId = registerService.findById(id);
        byId.setPassword(null);
        model.addAttribute("registrationData", byId);
        return "profile";
    }

    @PostMapping("users/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute("registrationData") @Valid ChangeUserDataDTO changeUserDataDTO,
                           BindingResult results) {
        if (results.hasErrors()) {
            return "profile";
        }
        RegistrationDTO registrationDTO = registerService.findById(id);
        registrationDTO.setName(changeUserDataDTO.getName());
        registrationDTO.setSurname(changeUserDataDTO.getSurname());
        registrationDTO.setPassword(changeUserDataDTO.getPassword());
        log.debug("User before saving to database: {}", registrationDTO);
        registerService.update(id, registrationDTO, Role.ROLE_USER);
        registrationDTO.setPassword(null);
        return "redirect:/admin/users/";
    }

    @GetMapping("users/delete/{id}")
    public String delete(@PathVariable Long id) {
        registerService.archive(id);
        return "redirect:/admin/users";
    }


}
