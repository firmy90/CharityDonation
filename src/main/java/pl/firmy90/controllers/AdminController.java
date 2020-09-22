package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
@AllArgsConstructor
@Slf4j
public class AdminController {

    @GetMapping
    public String showAdminIndexPage() {
        return "admin/admin-index";
    }

}
