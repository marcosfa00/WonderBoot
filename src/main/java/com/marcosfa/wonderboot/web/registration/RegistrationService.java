package com.marcosfa.wonderboot.web.registration;

import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTO;
import com.marcosfa.wonderboot.web.registration.dto.RegistrationUserDTOAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final WonderbootUserRepository wonderbootUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegistrationUserDTOAdapter registrationUserDTOAdapter;
    private RegistrationService(WonderbootUserRepository wonderbootUserRepository, PasswordEncoder passwordEncoder, RegistrationUserDTOAdapter registrationUserDTOAdapter) {
        this.wonderbootUserRepository = wonderbootUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.registrationUserDTOAdapter = registrationUserDTOAdapter;
    }

    public void RegisterUser(RegistrationUserDTO registrationUserDTO) {
        registrationUserDTO.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
       WonderbootUser user = registrationUserDTOAdapter.adapt(registrationUserDTO);
       wonderbootUserRepository.save(user);

    }
    public void RegisterUser1(WonderbootUser wonderbootUser) {
        wonderbootUser.setPassword(passwordEncoder.encode(wonderbootUser.getPassword()));

        wonderbootUserRepository.save(wonderbootUser);

    }
}
