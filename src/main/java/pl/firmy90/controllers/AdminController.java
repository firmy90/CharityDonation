package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.firmy90.dtos.ChangeUserDataDTO;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.Role;
import pl.firmy90.services.interfaces.RegisterService;

import javax.validation.Valid;

@RequestMapping("/admin")
@Controller
@AllArgsConstructor
@Slf4j
public class AdminController {
    private final RegisterService registerService;

    @GetMapping
    public String showAdminIndexPage() {
        return "admin/admin-index";
    }

    @GetMapping("profile")
    public String showUSerToEdit(Model model) {
        RegistrationDTO byId = registerService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        byId.setPassword(null);
        model.addAttribute("registrationData", byId);
        return "profile";
    }

    @GetMapping("profile/show")
    public String showAdminData(Model model) {
        RegistrationDTO byId = registerService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        byId.setPassword(null);
        model.addAttribute("registrationData", byId);
        return "admin/admin-profile-show";
    }

    @PostMapping("profile")
    public String editUser(@ModelAttribute("registrationData") @Valid ChangeUserDataDTO changeUserDataDTO,
                           BindingResult results) {
        if (results.hasErrors()) {
            return "/profile";
        }
        RegistrationDTO byUsername = registerService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        byUsername.setUsername(byUsername.getUsername());
        byUsername.setUserId(byUsername.getUserId());
        byUsername.setName(changeUserDataDTO.getName());
        byUsername.setSurname(changeUserDataDTO.getSurname());
        byUsername.setPassword(changeUserDataDTO.getPassword());
        log.debug("User before saving to database: {}", byUsername);
        registerService.update(Long.valueOf(byUsername.getUserId()), byUsername, Role.ROLE_ADMIN);
        byUsername.setPassword(null);
        return "redirect:/admin/profile/show";
    }

}
