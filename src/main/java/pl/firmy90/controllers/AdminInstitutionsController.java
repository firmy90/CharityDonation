package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.services.interfaces.InstitutionService;

import java.util.List;

@RequestMapping("/admin")
@Controller
@AllArgsConstructor
@Slf4j
public class AdminInstitutionsController {
    private final InstitutionService institutionService;

    @GetMapping("institutions")
    public String showInstitutions(Model model) {
        List<InstitutionDTO> institutionDTOS = institutionService.showInstitutions();
        log.debug("InstitutionsDTO list: {}", institutionDTOS.toString());
        model.addAttribute("institutions",institutionDTOS);
        return "admin/admin-institutions";
    }

    @GetMapping("institutions/edit/{id}")
    public String showInstitutionToEdit(@PathVariable Long id, Model model){
        model.addAttribute("institution", institutionService.findById(id));
        return "admin/admin-institutions-form";
    }

    @PostMapping(path={"institutions/edit/{id}"})
    public String editInstitution(@PathVariable Long id, @ModelAttribute("institution") InstitutionDTO institutionDTO){
        log.debug("InstitutionDTO object: {}",institutionDTO.toString());
        institutionService.updateInstitution(id, institutionDTO);
        return "redirect:/admin/institutions/";
    }

    @GetMapping("institutions/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionService.archiveInstitution(id);
        return "redirect:/admin/institutions";
    }

    @GetMapping("institutions/add")
    public String showInstitutionForm(Model model){
        model.addAttribute("institution", new InstitutionDTO());
        return "admin/admin-institutions-form";
    }

    @PostMapping("institutions/add")
    public String addInstitutionForm(@ModelAttribute("institution") InstitutionDTO institutionDTO){
        institutionService.saveInstitution(institutionDTO);
        return "redirect:/admin/institutions";
    }



}
