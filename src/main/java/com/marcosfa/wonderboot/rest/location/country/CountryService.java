package com.marcosfa.wonderboot.rest.location.country;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CountryService {
    private static final String PATH = "http://localhost:8081/api/countries";

    private final RestTemplate restTemplate;

    public CountryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    Country[] searchCountry(final String term){
        return restTemplate.getForObject(PATH, Country[].class, term);
    }


}
