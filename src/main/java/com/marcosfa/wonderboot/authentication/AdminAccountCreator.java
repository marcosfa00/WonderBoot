package com.marcosfa.wonderboot.authentication;

import com.marcosfa.wonderboot.web.profile.Profile;
import com.marcosfa.wonderboot.web.registration.RegistrationService;
import com.marcosfa.wonderboot.web.registration.UserExistsException;
import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AdminAccountCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminAccountCreator.class);

    private AdminAccountCreator(final RegistrationService registrationService) {


        WonderbootUser admin1 = createAdminUser();
        try{
            registrationService.registerUser(admin1);
        } catch (UserExistsException e){
            LOGGER.debug("admin already exists");
        }


    }

    private WonderbootUser createAdminUser() {
        WonderbootUser wonderbootUser = new WonderbootUser();
       wonderbootUser.setPassword("admin");
       wonderbootUser.setProfile(createAdminProfile());
        wonderbootUser.setAdmin(true);
        return wonderbootUser;
    }

    private Profile createAdminProfile(){
        Profile profile = new Profile();
        profile.setUsername("admin");
        profile.setName("Administrador");
        profile.setSurname("Avendaño");
        profile.setEmail("admin@marcosfa.com");
        profile.setCountryCode("USA");
        profile.setBirthDate(LocalDate.of(2000, 10, 29));
        return profile;
    }
}
