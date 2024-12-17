package com.marcosfa.wonderboot.rest.location.country.dto;

import com.marcosfa.wonderboot.rest.location.country.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CountryDTOAdapter {

    public CountryDTO adaptCountry(final Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCode(country.getCode());
        countryDTO.setName(country.getName());
        return countryDTO;
    }

    public Country adaptCountryDTO(final CountryDTO countryDTO) {
        Country country = new Country();
        country.setCode(countryDTO.getCode());
        country.setName(countryDTO.getName());
        return country;
    }

    public CountryDTO[] adaptCountries(final Country[] countries) {
        return Arrays.stream(countries)
                .map(this::adaptCountry)
                .toArray(CountryDTO[]::new);
    }
}
