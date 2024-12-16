package com.marcosfa.wonderboot.web.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistrationController {
    @GetMapping("/login")
    String login() {return "login";}

    @GetMapping("/register")
    String register() {return "register";}



}
