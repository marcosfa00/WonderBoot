package com.marcosfa.wonderboot.rest.location.city;

import com.marcosfa.wonderboot.rest.location.country.Country;

public class City {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(final Double lat) {
        this.latitude = lat;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(final Double lng) {
        this.longitude = lng;
    }
}
