package com.marcosfa.wonderboot.web.trips.dto;

import java.util.List;

public class TripDataDTO {
    private Long id;
    private String name;

    private List<TripCityDTO> cities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TripCityDTO> getCities() {
        return cities;
    }

    public void setCities(List<TripCityDTO> cities) {
        this.cities = cities;
    }
}
