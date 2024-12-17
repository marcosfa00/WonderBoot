package com.marcosfa.wonderboot.web.registration;

import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTOAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final WonderbootUserRepository wonderbootUserRepository;
    private final PasswordEncoder passwordEncoder;
    private RegistrationService(WonderbootUserRepository wonderbootUserRepository, PasswordEncoder passwordEncoder, RegistrationUserDTOAdapter registrationUserDTOAdapter) {
        this.wonderbootUserRepository = wonderbootUserRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public void RegisterUser(WonderbootUser wonderbootUser) throws UserExistsException {
        if (emailExists(wonderbootUser)) {
            throw new UserExistsException(UserExistsException.ErrorType.EMAIL_EXISTS);
        }
        if (usernameExists(wonderbootUser)) {
            throw new UserExistsException(UserExistsException.ErrorType.USERNAME_EXISTS);
        }
        // encript password of the new user & save on our DB
        wonderbootUser.setPassword(passwordEncoder.encode(wonderbootUser.getPassword()));
       wonderbootUserRepository.save(wonderbootUser);

    }

    public boolean emailExists(WonderbootUser wonderbootUser) {
        return wonderbootUserRepository.findByEmail(wonderbootUser.getEmail()).isPresent();
    }

    public boolean usernameExists(WonderbootUser wonderbootUser) {
        return wonderbootUserRepository.findByUsername(wonderbootUser.getUsername()).isPresent();
    }



}
