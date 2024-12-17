package com.marcosfa.wonderboot.web.registration.dto;


import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;
import java.util.Date;

public class RegistrationUserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    //@NotNull
    //@Valid
    //private CountryDTO country;
    @Email
    @NotEmpty(message = "Email is required.")
    private String email;
    @NotEmpty(message = "Password is required.")
    private String password;
    @NotEmpty(message = "Password confirmation is required.")
    private String repeatPassword;
    @NotNull
    private LocalDate dateOfBirth;

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank String surname) {
        this.surname = surname;
    }

    /*public @NotNull @Valid CountryDTO getCountry() {
        return country;
    }

    public void setCountry(@NotNull @Valid CountryDTO country) {
        this.country = country;
    }*/

    public @Email @NotEmpty(message = "Email is required.") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotEmpty(message = "Email is required.") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Password is required.") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password is required.") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "Password confirmation is required.") String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(@NotEmpty(message = "Password confirmation is required.") String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public @NotNull LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
