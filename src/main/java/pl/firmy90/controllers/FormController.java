package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.firmy90.model.domain.entity.Donation;
import pl.firmy90.services.interfaces.CategoryService;
import pl.firmy90.services.interfaces.DonationService;
import pl.firmy90.services.interfaces.InstitutionService;


@Controller
@Slf4j
@RequestMapping()
@AllArgsConstructor
public class FormController {
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;


    @GetMapping("/form")
    public String prepareFormDonation(Model model) {
        model.addAttribute("institutions", institutionService.showInstitutions());
        model.addAttribute("categories", categoryService.showCategories());
        model.addAttribute("donation", new Donation());
        log.debug("institutions list: {}", institutionService.showInstitutions().toString());
        log.debug("categories list: {}", categoryService.showCategories().toString());
        return "form";
    }

    @PostMapping("/form")
    public String addDonation(@ModelAttribute("donation") Donation donation) {
        log.debug("donation object: {}", donation.toString());
        donationService.saveFormDonation(donation);
        return "redirect:/form-confirmation";
    }

    @GetMapping("/form-confirmation")
    public String formConfirmation() {
        return "form-confirmation";
    }


}
