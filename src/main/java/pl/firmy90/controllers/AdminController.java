package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.services.interfaces.InstitutionService;

import java.util.List;

@RequestMapping("/admin")
@Controller
@AllArgsConstructor
@Slf4j
public class AdminController {
    private final InstitutionService institutionService;

    @GetMapping
    public String showAdminIndexPage() {
        return "admin/admin-index";
    }



}
