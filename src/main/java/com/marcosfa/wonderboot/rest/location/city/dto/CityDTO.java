package com.marcosfa.wonderboot.rest.location.city.dto;

import jakarta.validation.constraints.NotNull;

public class CityDTO {

    @NotNull
    private Long id;
    private String name;
    private String countryName;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }
}
