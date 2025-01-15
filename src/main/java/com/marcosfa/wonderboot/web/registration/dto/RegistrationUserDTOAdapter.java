package com.marcosfa.wonderboot.web.registration.dto;

import com.marcosfa.wonderboot.rest.location.country.Country;
import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTOAdapter;
import com.marcosfa.wonderboot.web.profile.Profile;
import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUserDTOAdapter {

    public WonderbootUser adapt(final RegistrationUserDTO userDTO) {
        WonderbootUser user = new WonderbootUser();
        user.setAdmin(false);
        user.setPassword(userDTO.getPassword());
        user.setProfile(createProfile(userDTO));
        String code =userDTO.getCountry().getCode();
        System.out.println("Country code -> "+code);
        return user;
    }


    private Profile createProfile(final RegistrationUserDTO registrationUser) {
        Profile profile = new Profile();
        profile.setCountryCode(registrationUser.getCountry().getCode());
        profile.setUsername(registrationUser.getUsername());
        profile.setName(registrationUser.getName());
        profile.setSurname(registrationUser.getSurname());
        profile.setBirthDate(registrationUser.getDateOfBirth());
        profile.setEmail(registrationUser.getEmail());
        return profile;
    }

}
