package com.marcosfa.wonderboot.web.registration;

import com.marcosfa.wonderboot.rest.location.country.Country;
import com.marcosfa.wonderboot.rest.location.country.CountryService;
import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTO;
import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTOAdapter;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTOAdapter;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class RegistrationController {
    private final RegistrationService registrationService;
    private final CountryService countryService;
    private final RegistrationUserDTOAdapter registrationUserDTOAdapter;
    private final CountryDTOAdapter countryDTOAdapter;

    private RegistrationController(final RegistrationService registrationService,
                                   final CountryService countryService,
                                   final RegistrationUserDTOAdapter registrationUserDTOAdapter,
                                   final CountryDTOAdapter countryDTOAdapter) {
        this.registrationService = registrationService;
        this.countryService = countryService;
        this.registrationUserDTOAdapter = registrationUserDTOAdapter;
        this.countryDTOAdapter = countryDTOAdapter;
    }

    @GetMapping("/login")
    String login() {return "login";}

    @GetMapping("/signup")
    public String register(@ModelAttribute("registrationUser") final RegistrationUserDTO registrationUser) {

        return "signup";
    }

    @PostMapping(value = "signup")
    public String signup(@Valid @ModelAttribute("registrationUser") final RegistrationUserDTO registrationUser, final BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Optional.ofNullable(registrationUser.getCountry())
                    .map(CountryDTO::getCode)
                    .flatMap(countryService::findCountryByCode)
                    .map(countryDTOAdapter::adaptCountry)
                    .ifPresent(registrationUser::setCountry);

            return "registration";
        }
        try {
            WonderbootUser wonderbootUser = registrationUserDTOAdapter.adapt(registrationUser);
            registrationService.registerUser(wonderbootUser);
        } catch (UserExistsException e) {
            String errorField = getErrorField(e.getErrorType());
            bindingResult.addError(new FieldError("registrationUser", errorField, e.getErrorType().name()));
            return "registration";
        }
        return "redirect:/login?registered";
    }

    private String getErrorField(final UserExistsException.ErrorType errorType) {
        switch (errorType) {
            case EMAIL_EXISTS:
                return "email";
            case USERNAME_EXISTS:
                return "username";
            default:
                return "unknown";
        }
    }

    @GetMapping("/admin")
    public String admin() {
        return "prueba-admin";
    }



}
