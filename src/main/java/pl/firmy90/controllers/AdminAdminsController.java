package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class AdminAdminsController {
    private final RegisterService registerService;


    @GetMapping("admins/add")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "/register";
    }

    @PostMapping("admins/add")
    public String registerAdmin(@ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
        registerService.registerAdmin(registrationDTO);
        return "redirect:/admin/admins";
    }

    @GetMapping("admins")
    public String showAdmins(Model model) {
        List<RegistrationDTO> registrationDTOS = registerService.showActiveUsersByRole(Role.ROLE_ADMIN);
        model.addAttribute("registrationData", registrationDTOS);
        return "admin/admin-admins";
    }

    @GetMapping("admins/edit/{id}")
    public String showAdminToEdit(@PathVariable Long id, Model model) {
        RegistrationDTO byId = registerService.findById(id);
        byId.setPassword(null);
        model.addAttribute("registrationData", byId);
        return "register";
    }

    @PostMapping("admins/edit/{id}")
    public String editAdmin(@PathVariable Long id, @ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
        registerService.update(id, registrationDTO, Role.ROLE_ADMIN);
        return "redirect:/admin/admins/";
    }

    @GetMapping("admins/delete/{id}")
    public String delete(@PathVariable Long id) {
        registerService.delete(id);
        return "redirect:/admin/admins";
    }


}
