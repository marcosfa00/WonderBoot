package com.marcosfa.wonderboot.web.registration;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WonderbootUserRepository extends CrudRepository<WonderbootUser, Long> {
    Optional<WonderbootUser> findByUsername(String username);
}
