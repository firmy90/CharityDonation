package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.firmy90.dtos.ChangeUserDataDTO;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.dtos.RegistrationDTO;
import pl.firmy90.model.domain.entity.Role;
import pl.firmy90.services.interfaces.CategoryService;
import pl.firmy90.services.interfaces.DonationService;
import pl.firmy90.services.interfaces.InstitutionService;
import pl.firmy90.services.interfaces.RegisterService;

import javax.validation.Valid;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final RegisterService registerService;

    @ModelAttribute("institutions")
    public List<InstitutionDTO> showInstitutions() {
        List<InstitutionDTO> institutionDTOS = institutionService.showInstitutions();
        log.debug("InstitutionsDTO list: {}", institutionDTOS.toString());
        return institutionDTOS;
    }
    @ModelAttribute("countDonations")
    public Long countCategories(){
        return donationService.countDonations();
    }

    @ModelAttribute("countQuantity")
    public Integer countQuantity(){
        return donationService.countQuantity();
    }


    @GetMapping
    public String homeAction(Model model) {
        return "home";
    }

    @GetMapping("profile")
    public String showUSerToEdit(Model model) {
        RegistrationDTO byId = registerService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        byId.setPassword(null);
        model.addAttribute("registrationData", byId);
        return "profile";
    }

    @PostMapping("profile")
    public String editUser(@ModelAttribute("registrationData") @Valid ChangeUserDataDTO changeUserDataDTO,
                           BindingResult results) {
        if (results.hasErrors()) {
            return "/profile";
        }
        RegistrationDTO byUsername = registerService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        byUsername.setUsername(byUsername.getUsername());
//        byUsername.setUserId(byUsername.getUserId());
        byUsername.setName(changeUserDataDTO.getName());
        byUsername.setSurname(changeUserDataDTO.getSurname());
        byUsername.setPassword(changeUserDataDTO.getPassword());
        log.debug("User before saving to database: {}", byUsername);
        registerService.update(Long.valueOf(byUsername.getUserId()), byUsername, Role.ROLE_USER);
        byUsername.setPassword(null);
        return "redirect:/home/profile/show";
    }

    @GetMapping("profile/show")
    public String showUSerData(Model model) {
        RegistrationDTO byId = registerService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        byId.setPassword(null);
        model.addAttribute("registrationData", byId);
        return "profile-show";
    }


}
