package com.marcosfa.wonderboot.web.registration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class WonderbootUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String surname;
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    private LocalDate dateOfBirth;
    private boolean admin;

    public WonderbootUser() {
    }

    public WonderbootUser(String username, String name, String surname, String email, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
