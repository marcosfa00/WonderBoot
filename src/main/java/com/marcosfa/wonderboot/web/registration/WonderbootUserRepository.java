package com.marcosfa.wonderboot.web.registration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface WonderbootUserRepository extends CrudRepository<WonderbootUser, Long> {
    Optional<WonderbootUser> findByProfileUsername(final String username);

    Optional<WonderbootUser> findByProfileEmail(final String email);

    List<WonderbootUser> findAll();

    void deleteById(Long id);

    <S extends WonderbootUser> S save(final S registrationUser);
}
