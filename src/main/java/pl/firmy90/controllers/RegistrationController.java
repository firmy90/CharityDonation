package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.services.interfaces.RegisterService;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping
@AllArgsConstructor
public class RegistrationController {
    private final RegisterService registerService;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationData") @Valid RegistrationDTO registrationDTO,
                           BindingResult results) {
        if (results.hasErrors()) {
            return "/register";
        }
        registerService.register(registrationDTO);
        return "redirect:/";
    }



}
