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
    private final PasswordEncoder passwordEncoder;
    private final WonderbootUserRepository wonderbootUserRepository;

    RegistrationController(PasswordEncoder passwordEncoder, WonderbootUserRepository wonderbootUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.wonderbootUserRepository = wonderbootUserRepository;
    }

    @GetMapping("/login")
    String login() {return "login";}

    @GetMapping("/signup")
    String register(Model model) {
        model.addAttribute("registrationUser", new RegistrationUserDTO());
        return "signup";}

    @PostMapping("/signup")// @Valid @ModelAttribute("registrationUser") , final BindingResult bindingResult
    public String signup( @Valid @ModelAttribute("registrationUser") final RegistrationUserDTO registrationUser) {
       String encodedPassword = passwordEncoder.encode(registrationUser.getPassword());
        WonderbootUser newUser = new WonderbootUser(
                registrationUser.getUsername(),
                registrationUser.getName(),
                registrationUser.getSurname(),
                registrationUser.getEmail(),
                encodedPassword,
                registrationUser.getDateOfBirth());
        wonderbootUserRepository.save(newUser);


        return "redirect:/login";
    }



}
