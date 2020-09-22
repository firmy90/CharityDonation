package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.Role;
import pl.firmy90.services.interfaces.RegisterService;

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
        return "/register";
    }

    @PostMapping("users/add")
    public String registerUser(@ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
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
        return "register";
    }

    @PostMapping("users/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
        registerService.update(id, registrationDTO, Role.ROLE_USER);
        return "redirect:/admin/users/";
    }

    @GetMapping("users/delete/{id}")
    public String delete(@PathVariable Long id) {
        registerService.archive(id);
        return "redirect:/admin/users";
    }


}
