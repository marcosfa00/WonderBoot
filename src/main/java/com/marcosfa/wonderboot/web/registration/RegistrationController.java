package com.marcosfa.wonderboot.web.registration;

import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTOAdapter;
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
    private final RegistrationUserDTOAdapter registrationUserDTOAdapter;

    RegistrationController(RegistrationService registrationService, RegistrationUserDTOAdapter registrationUserDTOAdapter) {
        this.registrationService = registrationService;
        this.registrationUserDTOAdapter = registrationUserDTOAdapter;
    }

    @GetMapping("/login")
    String login() {return "login";}

    @GetMapping("/signup")
    String register(Model model) {
        model.addAttribute("registrationUser", new RegistrationUserDTO());
        return "signup";}

    @PostMapping("/signup")
    public String signup( @Valid @ModelAttribute("registrationUser") final RegistrationUserDTO registrationUser) {
        WonderbootUser wonderbootuser = registrationUserDTOAdapter.adapt(registrationUser);
        try{
            registrationService.RegisterUser(wonderbootuser);
        } catch (UserExistsException e) {
            System.out.println("User already exists");
            return "signup";
        }

        return "redirect:/login";
    }



}
