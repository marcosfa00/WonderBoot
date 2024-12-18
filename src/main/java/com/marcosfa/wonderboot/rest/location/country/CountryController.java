package com.marcosfa.wonderboot.rest.location.country;

import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTO;
import com.marcosfa.wonderboot.rest.location.country.dto.CountryDTOAdapter;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/countries")
@RestController
public class CountryController {

    private final CountryService countryService;
    private final CountryDTOAdapter countryDTOAdapter;
    public CountryController(CountryService countryService, CountryDTOAdapter countryDTOAdapter) {
        this.countryService = countryService;
        this.countryDTOAdapter = countryDTOAdapter;
    }

    @GetMapping()
    public CountryDTO[] getCountry(@RequestParam final String term) {
        Country[] countries = countryService.searchCountry(term);
        return countryDTOAdapter.adaptCountries(countries);
    }


}
