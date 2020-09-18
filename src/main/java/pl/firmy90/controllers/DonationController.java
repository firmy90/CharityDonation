package pl.firmy90.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/form")
@AllArgsConstructor
public class DonationController {

    @GetMapping
    public String donationRegister(){
        return "form";
    }


}
