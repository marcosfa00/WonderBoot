package com.marcosfa.wonderboot.authentication.login;



import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import com.marcosfa.wonderboot.web.registration.WonderbootUserRepository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetails implements UserDetailsService {

    protected static final String USER_ROLE = "ROLE_USER";
    protected static final String ADMIN_ROLE = "ROLE_ADMIN";
    private final WonderbootUserRepository wonderbootUserRepository;

    public CustomUserDetails(WonderbootUserRepository wonderbootUserRepository) {
        this.wonderbootUserRepository = wonderbootUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WonderbootUser user = wonderbootUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserName not found"));
        // Roles
        List<SimpleGrantedAuthority> authorities = getAuthorities(user.isAdmin());
        // Log para depurar
        System.out.println("Usuario: " + username + " con roles: " + authorities);
        // return the user with roles
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<SimpleGrantedAuthority> getAuthorities(final boolean role) {
    return role ?toAuthorities(USER_ROLE, ADMIN_ROLE) : toAuthorities(USER_ROLE);
    }

    private List<SimpleGrantedAuthority> toAuthorities(String... authorities) {
        return Arrays.stream(authorities)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
