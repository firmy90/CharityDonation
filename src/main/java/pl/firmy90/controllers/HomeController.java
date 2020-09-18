package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.services.interfaces.CategoryService;
import pl.firmy90.services.interfaces.DonationService;
import pl.firmy90.services.interfaces.InstitutionService;

import java.util.List;


@Controller
@Slf4j
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeAction(Model model) {
        return "index";
    }
}
