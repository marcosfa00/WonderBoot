package com.marcosfa.wonderboot.authentication.login;

import com.marcosfa.wonderboot.web.registration.WonderbootUser;
import com.marcosfa.wonderboot.web.registration.WonderbootUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    protected static final String USER_ROLE = "ROLE_USER";
    protected static final String ADMIN_ROLE = "ROLE_ADMIN";
    private final WonderbootUserRepository wonderbootUserRepository;


    public CustomUserDetailsService(WonderbootUserRepository wonderbootUserRepository) {
        this.wonderbootUserRepository = wonderbootUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WonderbootUser user = new WonderbootUser();
        if (username.contains("@")){
            user = wonderbootUserRepository.findByProfileEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        }else{
            user = wonderbootUserRepository.findByProfileUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }


        // Roles
        List<SimpleGrantedAuthority> authorities = getAuthorities(user.isAdmin());
        // Log para depurar
        System.out.println("Usuario: " + username + " País: " +user.getProfile().getCountryCode()+" con roles: " + authorities);
        // return the user with roles
        return new User(user.getProfile().getUsername(), user.getPassword(), authorities);
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
