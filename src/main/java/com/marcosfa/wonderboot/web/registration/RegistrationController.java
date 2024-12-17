package com.marcosfa.wonderboot.web.registration;

import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
    private final RegistrationService registrationService;

    RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    String login() {return "login";}

    @GetMapping("/signup")
    String register(Model model) {
        model.addAttribute("registrationUser", new RegistrationUserDTO());
        return "signup";}

    @PostMapping("/signup")// @Valid @ModelAttribute("registrationUser") , final BindingResult bindingResult
    public String signup( @Valid @ModelAttribute("registrationUser") final RegistrationUserDTO registrationUser) {
        registrationService.RegisterUser(registrationUser);
        return "redirect:/login";
    }



}
