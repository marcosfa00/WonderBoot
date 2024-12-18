package com.marcosfa.wonderboot.authentication;

import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTO;
import com.marcosfa.wonderboot.web.registration.RegistrationService;
import com.marcosfa.wonderboot.web.registration.UserExistsException;
import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTOAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AdminAccountCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminAccountCreator.class);

    private AdminAccountCreator(final RegistrationService registrationService) {


        WonderbootUser admin1 = createAdminUser();
        admin1.setAdmin(true);
        try{
            registrationService.registerUser(admin1);
        } catch (UserExistsException e){
            LOGGER.debug("admin already exists");
        }


    }

    private WonderbootUser createAdminUser() {
        RegistrationUserDTOAdapter registrationUserDTOAdapter = new RegistrationUserDTOAdapter();
        WonderbootUser user = registrationUserDTOAdapter.adapt(createAdminUserDTO());
        user.setAdmin(true);
        return user;
    }

    private RegistrationUserDTO createAdminUserDTO(){
        RegistrationUserDTO user = new RegistrationUserDTO();
        user.setUsername("admin");
        user.setName("Administrador");
        user.setSurname("Avendaño");
        user.setEmail("admin@marcosfa.com");
        user.setPassword("admin");
        CountryDTO country = new CountryDTO();
        country.setCode("USA");
        country.setName("United States");
        user.setCountry(country);
        user.setDateOfBirth(LocalDate.of(2000,10,29));
        return user;
    }
}
