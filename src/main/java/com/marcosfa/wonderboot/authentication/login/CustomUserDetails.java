package com.marcosfa.wonderboot.authentication.login;



import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import com.marcosfa.wonderboot.web.registration.WonderbootUserRepository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CustomUserDetails implements UserDetailsService {
    private final WonderbootUserRepository wonderbootUserRepository;
    public CustomUserDetails(WonderbootUserRepository wonderbootUserRepository) {
        this.wonderbootUserRepository = wonderbootUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WonderbootUser user = wonderbootUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserName not found"));
        return new User(user.getUsername(), user.getPassword(), List.of());
    }
}
