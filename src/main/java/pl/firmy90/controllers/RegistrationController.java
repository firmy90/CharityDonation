package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.services.interfaces.RegisterService;

@Controller
@Slf4j
@RequestMapping
@AllArgsConstructor
public class RegistrationController {
    private final RegisterService registerService;

    @GetMapping(path = {"/register","/admin/users/add"})
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
        registerService.register(registrationDTO);
        return "redirect:/";
    }

    @PostMapping("/admin/users/add")
    public String registerUSer(@ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
        registerService.register(registrationDTO);
        return "redirect:/admin/users";
    }

}
