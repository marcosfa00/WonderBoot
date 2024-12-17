package com.marcosfa.wonderboot.web.registration;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WonderbootUserRepository extends CrudRepository<WonderbootUser, Long> {
    Optional<WonderbootUser> findByUsername(final String username);

    Optional<WonderbootUser> findByEmail(final String email);
}
