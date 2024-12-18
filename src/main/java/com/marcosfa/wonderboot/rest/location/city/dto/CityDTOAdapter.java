package com.marcosfa.wonderboot.rest.location.city.dto;

import com.marcosfa.wonderboot.rest.location.city.City;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CityDTOAdapter {

    public CityDTO adaptCity(final City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setCountryName(city.getCountry().getName());
        return cityDTO;
    }

    public CityDTO[] adaptCities(final City[] cities) {
        return Arrays.stream(cities)
                .map(this::adaptCity)
                .toArray(CityDTO[]::new);
    }
}

