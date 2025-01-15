package com.marcosfa.wonderboot.web.registration;

import com.marcosfa.wonderboot.rest.location.country.Country;
import com.marcosfa.wonderboot.web.profile.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class WonderbootUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Password is required")
    private String password;
    @JoinColumn(name = "profile_Id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Profile profile;
    private LocalDate createdDate;
    private boolean admin;

    public WonderbootUser() {
    }

    public WonderbootUser(Long id, String password, Profile profile, LocalDate createdDate, boolean admin) {
        this.id = id;
        this.password = password;
        this.profile = profile;
        this.createdDate = createdDate;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password is required") String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}