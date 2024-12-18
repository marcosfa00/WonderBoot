package com.marcosfa.wonderboot.rest.location.country.dto;

import jakarta.validation.constraints.NotBlank;


public class CountryDTO {

    @NotBlank
    private String code;
    private String name;

    public @NotBlank String getCode() {
        return code;
    }

    public void setCode(@NotBlank String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}