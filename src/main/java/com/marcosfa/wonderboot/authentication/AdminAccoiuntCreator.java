package com.marcosfa.wonderboot.authentication;

import com.marcosfa.wonderboot.web.registration.RegistrationService;
import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTOAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AdminAccoiuntCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminAccoiuntCreator.class);

    private AdminAccoiuntCreator(final RegistrationService registrationService, RegistrationUserDTOAdapter registrationUserDTOAdapter) {

        RegistrationUserDTO admin = createAdminUser();
        WonderbootUser admin1 = registrationUserDTOAdapter.adapt(admin);
        admin1.setAdmin(true);
        registrationService.RegisterUser1(admin1);

    }


    private RegistrationUserDTO createAdminUser(){
        RegistrationUserDTO user = new RegistrationUserDTO();
        user.setUsername("admin");
        user.setName("Administrador");
        user.setSurname("Avendaño");
        user.setEmail("admin@marcosfa.com");
        user.setPassword("admin");
        user.setDateOfBirth(LocalDate.of(2000,10,29));
        return user;
    }
}
