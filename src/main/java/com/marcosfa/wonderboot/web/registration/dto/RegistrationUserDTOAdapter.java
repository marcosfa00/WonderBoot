package com.marcosfa.wonderboot.web.registration.dto;

import com.marcosfa.wonderboot.rest.location.country.Country;
import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTOAdapter;
import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUserDTOAdapter {

    public WonderbootUser adapt(RegistrationUserDTO userDTO) {
        WonderbootUser user = new WonderbootUser();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        String code =userDTO.getCountry().getCode();
        System.out.println("Country code -> "+code);
        user.setCountryCode(code);
        user.setAdmin(false);
        return user;
    }

}
