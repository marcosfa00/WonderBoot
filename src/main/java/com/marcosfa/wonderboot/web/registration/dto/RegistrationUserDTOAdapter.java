package com.marcosfa.wonderboot.web.registration.dto;

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

        return user;
    }

}
