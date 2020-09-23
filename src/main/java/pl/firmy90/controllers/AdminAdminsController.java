package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
public class AdminAdminsController {
    private final RegisterService registerService;


    @GetMapping("admins/add")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "register";
    }

    @PostMapping("admins/add")
    public String registerAdmin(@ModelAttribute("registrationData") @Valid RegistrationDTO registrationDTO,
                                BindingResult results) {
        if (results.hasErrors()) {
            return "register";
        }
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
        return "admin/admin-edit-some-admin";
    }

    @PostMapping("admins/edit/{id}")
    public String editAdmin(@PathVariable Long id, @ModelAttribute("registrationData") @Valid ChangeUserDataDTO changeUserDataDTO,
                            BindingResult results) {
        if (results.hasErrors()) {

            return "admin/admin-edit-some-admin";
        }
        RegistrationDTO registrationDTO = registerService.findById(id);
        registrationDTO.setName(changeUserDataDTO.getName());
        registrationDTO.setSurname(changeUserDataDTO.getSurname());
        registrationDTO.setPassword(changeUserDataDTO.getPassword());
        log.debug("Admin before saving to database: {}", registrationDTO);
        registerService.update(id, registrationDTO, Role.ROLE_ADMIN);
        registrationDTO.setPassword(null);
        return "redirect:/admin/admins/";
    }

    @GetMapping("admins/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        RegistrationDTO byUsername = registerService.findByUsername(name);
        if (id.equals(Long.valueOf(byUsername.getUserId()))){
            redirectAttributes.addFlashAttribute("cannotDeleteYourself", "Nie można usunąć siebie samego");
            return "redirect:/admin/admins";
        }
        registerService.delete(id);
        return "redirect:/admin/admins";
    }

}
