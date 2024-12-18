package com.marcosfa.wonderboot.rest.location.city;


import com.marcosfa.wonderboot.config.LocationApiProperties;
import com.marcosfa.wonderboot.rest.location.LocationResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CityService {

    //private static final String BASE_URL = "http://localhost:8081"; // URL base de la API
    private static final String PATH = "/api/cities";
    private static final String TERM_QUERY_PARAM = "term";
    private final RestTemplate restTemplate;
    private final String locationApiHost;

    public CityService(final RestTemplateBuilder restTemplateBuilder,
            LocationApiProperties locationApiProperties,
                       final LocationResponseErrorHandler locationResponseErrorHandler) {
        // Registramos locationResponseErrorHandler para manejar errores
        this.restTemplate = restTemplateBuilder.errorHandler(locationResponseErrorHandler)
                .build();
        locationApiHost = locationApiProperties.getHost();
    }

    public City[] findCities(final String term) {
        URI uri = UriComponentsBuilder.fromUriString(locationApiHost)
                .path(PATH)
                .queryParam(TERM_QUERY_PARAM, term)
                .build()
                .toUri();

        return restTemplate.getForObject(uri, City[].class);
    }

    public Optional<City> findCityById(final Long cityId) {
        URI uri = UriComponentsBuilder.fromUriString(locationApiHost)
                .path(PATH + "/{id}")
                .buildAndExpand(cityId)
                .toUri();

        // En caso de error devolvemos un Optional vacío
        ResponseEntity<City> responseEntity = restTemplate.getForEntity(uri, City.class);
        if (responseEntity.getStatusCode().isError()) {
            return Optional.empty();
        }
        return Optional.ofNullable(responseEntity.getBody());
    }
}